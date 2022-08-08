package com.impactit.ihotel.domains.hotels.services;

import com.impactit.ihotel.domains.hotels.domain.entities.Room;
import com.impactit.ihotel.domains.hotels.domain.persistence.RoomRepository;
import com.impactit.ihotel.domains.hotels.domain.service.RoomService;
import com.impactit.ihotel.shared.mapping.exceptions.ResourceNotFoundException;
import com.impactit.ihotel.shared.mapping.exceptions.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService {

    private static final String ENTITY = "administrators";

    @Autowired
    private final RoomRepository roomRepository;

    private final Validator validator;

    public RoomServiceImpl(RoomRepository roomRepository, Validator validator) {
        this.roomRepository = roomRepository;
        this.validator = validator;
    }

    @Override
    public List<Room> getAll() {
        return this.roomRepository.findAll();
    }

    @Override
    public Room create(Room room) {
        Set<ConstraintViolation<Room>> violations = this.validator.validate(room);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return roomRepository.save(room);
    }

    @Override
    public Room update(Long roomId, Room request) {
        return new Room();
    }

    @Override
    public ResponseEntity<?> delete(Long roomId) {
        return roomRepository.findById(roomId).map(room -> {
            roomRepository.delete(room);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, roomId));
    }

    @Override
    public Room getById(Long id) {
        return  roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

}
