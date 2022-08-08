package com.impactit.ihotel.domains.hotels.domain.persistence;

import com.impactit.ihotel.domains.hotels.domain.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Override
    List<Room> findAll();

    @Override
    Room getById(Long id);
}
