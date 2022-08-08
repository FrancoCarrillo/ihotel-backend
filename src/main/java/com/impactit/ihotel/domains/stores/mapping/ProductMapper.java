package com.impactit.ihotel.domains.stores.mapping;

import com.impactit.ihotel.domains.stores.domain.entities.Product;
import com.impactit.ihotel.domains.stores.resource.ProductRequestResource;
import com.impactit.ihotel.domains.stores.resource.ProductResource;

import com.impactit.ihotel.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ProductMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public ProductResource toResource(Product model) {
        return mapper.map(model, ProductResource.class);
    }

    public Page<ProductResource> modelListPage(List<Product> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ProductResource.class), pageable, modelList.size());
    }

    public Product toModel(ProductRequestResource resource){
        return mapper.map(resource, Product.class);
    }
}
