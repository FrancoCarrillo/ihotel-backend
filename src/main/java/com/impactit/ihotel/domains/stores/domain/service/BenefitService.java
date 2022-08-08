package com.impactit.ihotel.domains.stores.domain.service;

import com.impactit.ihotel.domains.stores.domain.entities.Benefit;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BenefitService {

    List<Benefit> getAll();

    Benefit create(Benefit benefit);

    Benefit update(Long benefitId, Benefit request);

    ResponseEntity<?> delete(Long benefitId);
}
