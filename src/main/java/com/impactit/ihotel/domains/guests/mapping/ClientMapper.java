package com.impactit.ihotel.domains.guests.mapping;

import com.impactit.ihotel.domains.guests.domain.entities.Client;
import com.impactit.ihotel.domains.guests.resource.ClientRequestResource;
import com.impactit.ihotel.domains.guests.resource.ClientResource;
import com.impactit.ihotel.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;


public class ClientMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public ClientResource toResource(Client model) {
        return mapper.map(model, ClientResource.class);
    }

    public Page<ClientResource> modelListPage(List<Client> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ClientResource.class), pageable, modelList.size());
    }

    public Client toModel(ClientRequestResource resource){
        return mapper.map(resource, Client.class);
    }


}
