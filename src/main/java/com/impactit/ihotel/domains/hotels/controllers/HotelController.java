package com.impactit.ihotel.domains.hotels.controllers;


import com.impactit.ihotel.domains.hotels.domain.entities.Hotel;
import com.impactit.ihotel.domains.hotels.domain.service.HotelService;
import com.impactit.ihotel.domains.hotels.mapping.HotelMapper;
import com.impactit.ihotel.domains.hotels.resources.HotelResource;
import com.impactit.ihotel.domains.hotels.resources.SaveHotelResource;
import com.impactit.ihotel.domains.reservations.resource.ReservationResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/hotels")
public class HotelController {
	@Autowired
	private final HotelService hotelService;

	private final HotelMapper mapper;
	public HotelController(HotelService hotelService, HotelMapper mapper) {
		this.hotelService = hotelService;
		this.mapper = mapper;
	}

	@GetMapping
	public List<Hotel> getAll() {
		return hotelService.getAll();
	}

	@GetMapping("/{id}")
	public Hotel getById(@PathVariable Long id) {
		return hotelService.getById(id);
	}

	@PostMapping
	public ResponseEntity<HotelResource> create(@RequestBody SaveHotelResource resource) {
		return new ResponseEntity<HotelResource>(
				this.mapper.toResource(
						this.hotelService.create(
								this.mapper.toModel(resource)
						)
				),
				HttpStatus.CREATED
		);
	}

	@DeleteMapping("/{hotelId}")
	public ResponseEntity<?> eraseHotel(@PathVariable Long hotelId) {
		return this.hotelService.delete(hotelId);
	}

}
