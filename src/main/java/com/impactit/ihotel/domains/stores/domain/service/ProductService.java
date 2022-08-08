package com.impactit.ihotel.domains.stores.domain.service;

import com.impactit.ihotel.domains.stores.domain.entities.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product create(Product product);

    Product update(Long productId, Product request);

    ResponseEntity<?> delete(Long productId);
}
