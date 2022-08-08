package com.impactit.ihotel.domains.administration.services;

import com.impactit.ihotel.domains.administration.domain.entities.Administrator;
import com.impactit.ihotel.domains.administration.domain.persistence.AdministratorRepository;
import com.impactit.ihotel.domains.administration.domain.service.AdministratorService;
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
public class AdministratorServiceImpl implements AdministratorService {

	private static final String ENTITY = "administrators";

	@Autowired
	private final AdministratorRepository administratorRepository;

	private final Validator validator;

	public AdministratorServiceImpl(AdministratorRepository administratorRepository, Validator validator) {
		this.administratorRepository = administratorRepository;
		this.validator = validator;
	}

	@Override
	public List<Administrator> getAll() {
		return administratorRepository.findAll();
	}

	@Override
	public Administrator create(Administrator administrator) {
		Set<ConstraintViolation<Administrator>> violations = this.validator.validate(administrator);
		if(!violations.isEmpty())
			throw new ResourceValidationException(ENTITY, violations);
		return administratorRepository.save(administrator);
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
	public Administrator update(Long administratorId, Administrator request) {
		return new Administrator();
	}

	@Override
	public ResponseEntity<?> delete(Long clientId) {
		return administratorRepository.findById(clientId).map(client -> {
			administratorRepository.delete(client);
			return ResponseEntity.ok().build();
		}).orElseThrow(()-> new ResourceNotFoundException(ENTITY, clientId));
	}

	@Override
	public Administrator getById(Long id) {
		return  administratorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
	}

}
