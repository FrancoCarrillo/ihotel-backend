package com.impactit.ihotel.domains.hotels.domain.service;

import com.impactit.ihotel.domains.hotels.domain.entities.Room;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoomService {
    List<Room> getAll();

    Room create(Room employee);

    Room update(Long employeeId, Room request);

    ResponseEntity<?> delete(Long employeeId);

    Room getById(Long id);
}
