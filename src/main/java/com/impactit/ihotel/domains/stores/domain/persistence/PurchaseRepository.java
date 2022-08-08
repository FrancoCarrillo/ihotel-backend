package com.impactit.ihotel.domains.stores.domain.persistence;

import com.impactit.ihotel.domains.stores.domain.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository  extends JpaRepository<Purchase, Long> {

    @Override
    List<Purchase> findAll();
}
