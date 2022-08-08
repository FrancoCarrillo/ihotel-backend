package com.impactit.ihotel.domains.hotels.domain.service;

import com.impactit.ihotel.domains.hotels.domain.entities.Hotel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HotelService {
    List<Hotel> getAll();

    Hotel create(Hotel administrator);

    Hotel update(Long administratorId, Hotel request);

    ResponseEntity<?> delete(Long administratorId);

    Hotel getById(Long id);
}
