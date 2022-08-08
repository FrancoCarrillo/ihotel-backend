package com.impactit.ihotel.domains.administration.services;

import com.impactit.ihotel.domains.administration.domain.entities.Business;
import com.impactit.ihotel.domains.administration.domain.persistence.BusinessRepository;
import com.impactit.ihotel.domains.administration.domain.service.BusinessService;
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
public class BusinessServiceImpl implements BusinessService {
    private static final String ENTITY = "businesses";

    @Autowired
    private final BusinessRepository businessRepository;

    private final Validator validator;

    public BusinessServiceImpl(BusinessRepository businessRepository, Validator validator) {
        this.businessRepository = businessRepository;
        this.validator = validator;
    }

    @Override
    public List<Business> getAll() {
        return this.businessRepository.findAll();
    }

    @Override
    public Business create(Business business) {
        Set<ConstraintViolation<Business>> violations = this.validator.validate(business);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return businessRepository.save(business);
    }

    @Override
    public Business update(Long businessId, Business request) {
        return new Business();
    }

    @Override
    public ResponseEntity<?> delete(Long businessId) {
        return businessRepository.findById(businessId).map(business -> {
            businessRepository.delete(business);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, businessId));
    }

    @Override
    public Business getById(Long id) {
        return  businessRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

}
