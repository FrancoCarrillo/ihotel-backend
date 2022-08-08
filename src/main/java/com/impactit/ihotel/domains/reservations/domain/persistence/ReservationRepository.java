package com.impactit.ihotel.domains.reservations.domain.persistence;

import com.impactit.ihotel.domains.reservations.domain.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long>{
    @Override
    List<Reservation> findAll();
    Reservation findByStatus(String status);
    Reservation findByReservationDate(Date date);
    Reservation findAllById(Long id);
}
