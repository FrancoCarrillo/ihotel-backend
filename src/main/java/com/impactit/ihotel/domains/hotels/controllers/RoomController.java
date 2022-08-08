package com.impactit.ihotel.domains.hotels.controllers;

import com.impactit.ihotel.domains.hotels.domain.entities.Room;
import com.impactit.ihotel.domains.hotels.domain.service.RoomService;
import com.impactit.ihotel.domains.hotels.mapping.RoomMapper;
import com.impactit.ihotel.domains.hotels.resources.HotelResource;
import com.impactit.ihotel.domains.hotels.resources.RoomResource;
import com.impactit.ihotel.domains.hotels.resources.SaveRoomResource;
import com.impactit.ihotel.domains.hotels.services.RoomServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    private final RoomMapper mapper;

    public RoomController(RoomService roomService, RoomMapper mapper) {
        this.roomService = roomService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<Room> getAll() {
        return roomService.getAll();
    }

    @GetMapping("/{id}")
    public Room getById(@PathVariable Long id) {
        return roomService.getById(id);
    }

    @PostMapping
    public ResponseEntity<RoomResource> create(@RequestBody SaveRoomResource resource) {
        return new ResponseEntity<RoomResource>(
                this.mapper.toResource(
                        this.roomService.create(
                                this.mapper.toModel(resource)
                        )
                ),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<?> eraseRoom(@PathVariable Long roomId) {
        return this.roomService.delete(roomId);
    }
}
