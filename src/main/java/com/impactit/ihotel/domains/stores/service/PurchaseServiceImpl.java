package com.impactit.ihotel.domains.stores.service;

import com.impactit.ihotel.domains.stores.domain.entities.Purchase;
import com.impactit.ihotel.domains.stores.domain.persistence.PurchaseRepository;
import com.impactit.ihotel.domains.stores.domain.service.PurchaseService;

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
public class PurchaseServiceImpl implements PurchaseService {
    private static final String ENTITY = "purchases";

    @Autowired
    private final PurchaseRepository purchaseRepository;

    private final Validator validator;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, Validator validator) {
        this.purchaseRepository = purchaseRepository;
        this.validator = validator;
    }

    @Override
    public List<Purchase> getAll() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase create(Purchase purchase) {
        Set<ConstraintViolation<Purchase>> violations = validator.validate(purchase);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase update(Long purchaseId, Purchase request) {
        Set<ConstraintViolation<Purchase>> violations = validator.validate(request);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return purchaseRepository.findById(purchaseId).map(purchase ->
                        purchaseRepository.save(purchase.withTotal(request.getTotal())))
                .orElseThrow(()->new ResourceNotFoundException(ENTITY, purchaseId));
    }

    @Override
    public ResponseEntity<?> delete(Long purchaseId) {
        return purchaseRepository.findById(purchaseId).map(purchase -> {
            purchaseRepository.delete(purchase);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, purchaseId));
    }
}
