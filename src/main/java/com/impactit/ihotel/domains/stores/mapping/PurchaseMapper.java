package com.impactit.ihotel.domains.stores.mapping;

import com.impactit.ihotel.domains.stores.domain.entities.Product;
import com.impactit.ihotel.domains.stores.domain.entities.Purchase;
import com.impactit.ihotel.domains.stores.resource.ProductRequestResource;
import com.impactit.ihotel.domains.stores.resource.ProductResource;
import com.impactit.ihotel.domains.stores.resource.PurchaseRequestResource;
import com.impactit.ihotel.domains.stores.resource.PurchaseResource;
import com.impactit.ihotel.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class PurchaseMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public PurchaseResource toResource(Purchase model) {
        return mapper.map(model, PurchaseResource.class);
    }

    public Page<PurchaseResource> modelListPage(List<Purchase> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, PurchaseResource.class), pageable, modelList.size());
    }

    public Purchase toModel(PurchaseRequestResource resource){
        return mapper.map(resource, Purchase.class);
    }
}
