package com.impactit.ihotel.domains.stores.controllers;

import com.impactit.ihotel.domains.stores.domain.service.PurchaseService;
import com.impactit.ihotel.domains.stores.mapping.PurchaseMapper;
import com.impactit.ihotel.domains.stores.resource.PurchaseRequestResource;
import com.impactit.ihotel.domains.stores.resource.PurchaseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/purchase")
public class PurchaseController {
    @Autowired
    private final PurchaseService purchaseService;

    private final PurchaseMapper mapper;

    public PurchaseController(PurchaseService purchaseService, PurchaseMapper mapper) {
        this.purchaseService = purchaseService;
        this.mapper = mapper;
    }


    @GetMapping
    public Page<PurchaseResource> getAllPurchase(Pageable pageable){
        return mapper.modelListPage(purchaseService.getAll(), pageable);
    }

    @PostMapping
    public ResponseEntity<PurchaseResource> createPurchase(@RequestBody PurchaseRequestResource resource) {
        return new ResponseEntity<>(mapper.toResource(purchaseService.create(
                mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{purchaseId}")
    public PurchaseResource updatePurchase( @PathVariable Long purchaseId,@RequestBody PurchaseRequestResource resource){
        return mapper.toResource(purchaseService.update(purchaseId, mapper.toModel(resource)));
    }

    @DeleteMapping("{purchaseId}")
    public ResponseEntity<?> deletePurchase (@PathVariable Long purchaseId) {
        return purchaseService.delete(purchaseId);
    }
}
