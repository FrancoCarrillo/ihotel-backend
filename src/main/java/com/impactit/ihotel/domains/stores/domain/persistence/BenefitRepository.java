package com.impactit.ihotel.domains.stores.domain.persistence;



import com.impactit.ihotel.domains.stores.domain.entities.Benefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenefitRepository extends JpaRepository<Benefit, Long> {

    @Override
    List<Benefit> findAll();
}
