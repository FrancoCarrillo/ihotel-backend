package com.impactit.ihotel.domains.administration.services;

import com.impactit.ihotel.domains.administration.domain.entities.Employee;
import com.impactit.ihotel.domains.administration.domain.persistence.EmployeeRepository;
import com.impactit.ihotel.domains.administration.domain.service.EmployeeService;

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
public class EmployeeServiceImpl implements EmployeeService {

    private static final String ENTITY = "employees";

    @Autowired
    private final EmployeeRepository employeeRepository;

    private final Validator validator;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, Validator validator) {
        this.employeeRepository = employeeRepository;
        this.validator = validator;
    }

    @Override
    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee create(Employee employee) {
        Set<ConstraintViolation<Employee>> violations = validator.validate(employee);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long employeeId, Employee request) {
        Set<ConstraintViolation<Employee>> violations = validator.validate(request);
        if(!violations.isEmpty())
            throw  new com.impactit.ihotel.shared.exception.ResourceValidationException(ENTITY, violations);

        return employeeRepository.findById(employeeId).map(employee->
                        employeeRepository.save(employee.withName(request.getName())
                                .withDni(request.getDni())
                                .withPhoneNumber(request.getPhoneNumber())
                                .withType(request.getType())
                                .withPhoneNumber(request.getPhoneNumber())
                                .withDni(request.getDni())))
                .orElseThrow(()->new com.impactit.ihotel.shared.exception.ResourceNotFoundException(ENTITY, employeeId));
    }

    @Override
    public ResponseEntity<?> delete(Long employeeId) {
        return employeeRepository.findById(employeeId).map(employee -> {
            employeeRepository.delete(employee);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, employeeId));
    }

    @Override
    public Employee getById(Long id) {
        return  employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

}
