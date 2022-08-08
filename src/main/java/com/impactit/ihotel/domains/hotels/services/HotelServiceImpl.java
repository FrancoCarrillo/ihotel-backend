package com.impactit.ihotel.domains.hotels.services;


import com.impactit.ihotel.domains.hotels.domain.entities.Hotel;
import com.impactit.ihotel.domains.hotels.domain.persistence.HotelRepository;
import com.impactit.ihotel.domains.hotels.domain.service.HotelService;
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
public class HotelServiceImpl implements HotelService {

	private static final String ENTITY = "hotels";

	@Autowired
	private final HotelRepository hotelRepository;

	private final Validator validator;

	public HotelServiceImpl(HotelRepository hotelRepository, Validator validator) {
		this.hotelRepository = hotelRepository;
		this.validator = validator;
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel create(Hotel hotel) {
		Set<ConstraintViolation<Hotel>> violations = this.validator.validate(hotel);
		if(!violations.isEmpty())
			throw new ResourceValidationException(ENTITY, violations);
		return hotelRepository.save(hotel);
	}

	/*@Override
	public Administrator update(Long administratorId, Administrator request) {
		Set<ConstraintViolation<Administrator>> violations = validator.validate(request);
		if(!violations.isEmpty())
			throw  new ResourceValidationException(ENTITY, violations);

		return administratorRepository.findById(administratorId).map(administrator ->
						administratorRepository.save(administrator.withName(request.getName())
								.withSurname(request.getSurname())
								.withAddress(request.getAddress())
								.withEmail(request.getEmail())
								.withPhoneNumber(request.getPhoneNumber())
								.withBornDate(request.getBornDate())
								.orElseThrow(()->new ResourceNotFoundException(ENTITY, administratorId));
	}*/

	@Override
	public Hotel update(Long hotelId, Hotel request) {
		return new Hotel();
	}

	@Override
	public ResponseEntity<?> delete(Long hotelId) {
		return hotelRepository.findById(hotelId).map(hotel -> {
			hotelRepository.delete(hotel);
			return ResponseEntity.ok().build();
		}).orElseThrow(()-> new ResourceNotFoundException(ENTITY, hotelId));
	}

	@Override
	public Hotel getById(Long id) {
		return  hotelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
	}

}
