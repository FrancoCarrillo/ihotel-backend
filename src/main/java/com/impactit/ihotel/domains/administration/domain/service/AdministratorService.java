package com.impactit.ihotel.domains.administration.domain.service;

import com.impactit.ihotel.domains.administration.domain.entities.Administrator;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdministratorService {
    List<Administrator> getAll();

    Administrator create(Administrator administrator);

    Administrator update(Long administratorId, Administrator request);

    ResponseEntity<?> delete(Long administratorId);

    Administrator getById(Long id);
}
