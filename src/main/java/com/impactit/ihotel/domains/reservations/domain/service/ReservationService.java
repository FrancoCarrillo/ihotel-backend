package com.impactit.ihotel.domains.reservations.domain.service;

import com.impactit.ihotel.domains.reservations.domain.entities.Reservation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAll();

    Reservation create(Reservation reservation);

    Reservation update(Long reservationId, Reservation request);

    ResponseEntity<?> delete (Long reservationId);
}
