package com.impactit.ihotel.domains.administration.domain.persistence;

import com.impactit.ihotel.domains.administration.domain.entities.Business;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessRepository extends JpaRepository<Business, Long> {
    @Override
    List<Business> findAll();

    @Override
    Business getById(Long id);
}
