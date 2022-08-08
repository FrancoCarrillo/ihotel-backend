package com.impactit.ihotel.domains.reservations.controllers;

import com.impactit.ihotel.domains.reservations.domain.service.ReservationService;
import com.impactit.ihotel.domains.reservations.mapping.ReservationMapper;
import com.impactit.ihotel.domains.reservations.resource.ReservationRequestResource;
import com.impactit.ihotel.domains.reservations.resource.ReservationResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping(value = "/reservations")
public class reservationController {
    @Autowired
    private final ReservationService reservationService;

    private final ReservationMapper mapper;


    public reservationController(ReservationService reservationService, ReservationMapper mapper) {
        this.reservationService = reservationService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ReservationResource> getAllReservation(Pageable pageable){
        return mapper.modelListPage(reservationService.getAll(), pageable);
    }

    @PostMapping("/create")

    public ResponseEntity<ReservationResource> createReservation (@RequestBody ReservationRequestResource resource) {
        return new ResponseEntity<ReservationResource>(mapper.toResource(reservationService.create(
                mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("/{reservationId}")
    public ReservationResource updateReservation( @PathVariable Long reservationId, @RequestBody ReservationRequestResource resource){
        return mapper.toResource(reservationService.update(reservationId, mapper.toModel(resource)));
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long reservationId) {
        return reservationService.delete(reservationId);
    }

}
