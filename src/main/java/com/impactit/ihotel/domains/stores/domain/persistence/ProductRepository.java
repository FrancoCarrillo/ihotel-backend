package com.impactit.ihotel.domains.stores.domain.persistence;

import com.impactit.ihotel.domains.stores.domain.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    List<Product> findAll();

}
