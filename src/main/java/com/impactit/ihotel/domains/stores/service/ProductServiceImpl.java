package com.impactit.ihotel.domains.stores.service;

import com.impactit.ihotel.domains.stores.domain.entities.Product;
import com.impactit.ihotel.domains.stores.domain.persistence.ProductRepository;
import com.impactit.ihotel.domains.stores.domain.service.ProductService;

import com.impactit.ihotel.shared.exception.ResourceNotFoundException;
import com.impactit.ihotel.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String ENTITY = "products";

    @Autowired
    private final ProductRepository productRepository;

    private final Validator validator;

    public ProductServiceImpl(ProductRepository productRepository, Validator validator) {
        this.productRepository = productRepository;
        this.validator = validator;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product create(Product product) {
        Set<ConstraintViolation<Product>> violations = validator.validate(product);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return productRepository.save(product);
    }

    @Override
    public Product update(Long productId, Product request) {
        Set<ConstraintViolation<Product>> violations = validator.validate(request);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return productRepository.findById(productId).map(product ->
                productRepository.save(product.withName(request.getName())
                        .withPrice(request.getPrice())
                        .withBrandName(request.getBrandName())))
                .orElseThrow(()->new ResourceNotFoundException(ENTITY, productId));
    }

    @Override
    public ResponseEntity<?> delete(Long productId) {
        return productRepository.findById(productId).map(product -> {
            productRepository.delete(product);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, productId));
    }
}
