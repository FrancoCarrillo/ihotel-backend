package com.impactit.ihotel.domains.administration.domain.service;

import com.impactit.ihotel.domains.administration.domain.entities.Business;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BusinessService {
    List<Business> getAll();

    Business create(Business business);

    Business update(Long businessId, Business request);

    ResponseEntity<?> delete(Long businessId);

    Business getById(Long id);
}
