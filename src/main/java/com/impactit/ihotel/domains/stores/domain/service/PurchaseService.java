package com.impactit.ihotel.domains.stores.domain.service;

import com.impactit.ihotel.domains.stores.domain.entities.Product;
import com.impactit.ihotel.domains.stores.domain.entities.Purchase;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PurchaseService {
    List<Purchase> getAll();

    Purchase create(Purchase purchase);

    Purchase update(Long purchaseId, Purchase request);

    ResponseEntity<?> delete(Long purchaseId);
}
