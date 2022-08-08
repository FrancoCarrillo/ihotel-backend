package com.impactit.ihotel.domains.administration.domain.service;

import com.impactit.ihotel.domains.administration.domain.entities.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    Employee create(Employee employee);

    Employee update(Long employeeId, Employee request);

    ResponseEntity<?> delete(Long employeeId);

    Employee getById(Long id);
}
