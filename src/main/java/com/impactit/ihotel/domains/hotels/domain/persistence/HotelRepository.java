package com.impactit.ihotel.domains.hotels.domain.persistence;

import com.impactit.ihotel.domains.hotels.domain.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    @Override
    List<Hotel> findAll();

    @Override
    Hotel getById(Long id);
}
