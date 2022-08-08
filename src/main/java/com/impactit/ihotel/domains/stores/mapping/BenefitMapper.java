package com.impactit.ihotel.domains.stores.mapping;

import com.impactit.ihotel.domains.stores.domain.entities.Benefit;
import com.impactit.ihotel.domains.stores.resource.BenefitRequestResource;
import com.impactit.ihotel.domains.stores.resource.BenefitResource;

import com.impactit.ihotel.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class BenefitMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public BenefitResource toResource(Benefit model) {
        return mapper.map(model, BenefitResource.class);
    }

    public Page<BenefitResource> modelListPage(List<Benefit> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, BenefitResource.class), pageable, modelList.size());
    }

    public Benefit toModel(BenefitRequestResource resource) {
        return mapper.map(resource, Benefit.class);
    }

}
