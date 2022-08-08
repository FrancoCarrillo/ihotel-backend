package com.impactit.ihotel.domains.reports.services;

import com.impactit.ihotel.domains.hotels.domain.entities.Hotel;
import com.impactit.ihotel.domains.hotels.domain.persistence.HotelRepository;
import com.impactit.ihotel.domains.reports.domain.entitities.Report;
import com.impactit.ihotel.domains.reports.domain.persistence.ReportRepository;
import com.impactit.ihotel.domains.reports.domain.services.ReportService;
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
public class ReportServiceImpl implements ReportService {
    private static final String ENTITY = "hotels";

    @Autowired
    private final ReportRepository reportRepository;

    private final Validator validator;

    public ReportServiceImpl(ReportRepository reportRepository, Validator validator) {
        this.reportRepository = reportRepository;
        this.validator = validator;
    }

    @Override
    public List<Report> getAll() {
        return reportRepository.findAll();
    }

    @Override
    public Report create(Report report) {
        Set<ConstraintViolation<Report>> violations = this.validator.validate(report);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return reportRepository.save(report);
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
    public Report update(Long hotelId, Report request) {
        return new Report();
    }

    @Override
    public ResponseEntity<?> delete(Long hotelId) {
        return reportRepository.findById(hotelId).map(hotel -> {
            reportRepository.delete(hotel);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, hotelId));
    }

    @Override
    public Report getById(Long id) {
        return  reportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }
}
