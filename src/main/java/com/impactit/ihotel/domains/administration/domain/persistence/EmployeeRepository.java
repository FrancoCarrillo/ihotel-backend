package com.impactit.ihotel.domains.administration.domain.persistence;

import com.impactit.ihotel.domains.administration.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Override
    List<Employee> findAll();

    @Override
    Employee getById(Long id);
}
