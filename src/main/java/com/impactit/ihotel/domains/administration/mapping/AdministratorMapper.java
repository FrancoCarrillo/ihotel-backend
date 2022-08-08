package com.impactit.ihotel.domains.administration.mapping;

import com.impactit.ihotel.domains.administration.domain.entities.Administrator;
import com.impactit.ihotel.domains.administration.resources.AdministratorResource;
import com.impactit.ihotel.domains.administration.resources.SaveAdministratorResource;
import com.impactit.ihotel.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class AdministratorMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public AdministratorResource toResource(Administrator model) {
        return mapper.map(model, AdministratorResource.class);
    }

    public Page<AdministratorResource> modelListPage(List<Administrator> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, AdministratorResource.class), pageable, modelList.size());
    }

    public Administrator toModel(SaveAdministratorResource resource) {
        return mapper.map(resource, Administrator.class);
    }
}
