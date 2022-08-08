package com.impactit.ihotel.domains.stores.service;

import com.impactit.ihotel.domains.stores.domain.entities.Benefit;
import com.impactit.ihotel.domains.stores.domain.persistence.BenefitRepository;
import com.impactit.ihotel.domains.stores.domain.service.BenefitService;

import com.impactit.ihotel.shared.exception.ResourceNotFoundException;
import com.impactit.ihotel.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class BenefitServiceImpl implements BenefitService {

    private static final String ENTITY = "benefits";

    @Autowired
    private final BenefitRepository benefitRepository;

    private final Validator validator;

    public BenefitServiceImpl(BenefitRepository benefitRepository, Validator validator) {
        this.benefitRepository = benefitRepository;
        this.validator = validator;
    }


    @Override
    public List<Benefit> getAll() {
        return benefitRepository.findAll();
    }

    @Override
    public Benefit create(Benefit benefit) {
        Set<ConstraintViolation<Benefit>> violations = validator.validate(benefit);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return benefitRepository.save(benefit);
    }

    @Override
    public Benefit update(Long benefitId, Benefit request) {

        Set<ConstraintViolation<Benefit>> violations = validator.validate(request);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return benefitRepository.findById(benefitId).map(benefit ->
                benefitRepository.save(benefit.withName(request.getName())
                        .withPrice(request.getPrice())))
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, benefitId));
    }

    @Override
    public ResponseEntity<?> delete(Long benefitId) {
        return benefitRepository.findById(benefitId).map(benefit -> {
            benefitRepository.delete(benefit);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, benefitId));

    }
}
