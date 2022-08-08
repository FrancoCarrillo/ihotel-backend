package com.impactit.ihotel.domains.administration.mapping;

import com.impactit.ihotel.domains.administration.domain.entities.Business;
import com.impactit.ihotel.domains.administration.resources.BusinessResource;
import com.impactit.ihotel.domains.administration.resources.SaveBusinessResource;
import com.impactit.ihotel.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class BusinessMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public BusinessResource toResource(Business model) {
        return mapper.map(model,BusinessResource.class);
    }

    public Page<BusinessResource> modelListPage(List<BusinessResource> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, BusinessResource.class), pageable, modelList.size());
    }

    public Business toModel(SaveBusinessResource resource) {
        return mapper.map(resource, Business.class);
    }
}
