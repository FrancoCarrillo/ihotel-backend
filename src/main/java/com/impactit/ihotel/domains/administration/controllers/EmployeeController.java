package com.impactit.ihotel.domains.administration.controllers;

import com.impactit.ihotel.domains.administration.domain.entities.Employee;
import com.impactit.ihotel.domains.administration.domain.service.EmployeeService;
import com.impactit.ihotel.domains.administration.mapping.EmployeeMapper;
import com.impactit.ihotel.domains.administration.resources.EmployeeResource;
import com.impactit.ihotel.domains.administration.resources.SaveEmployeeResource;

import com.impactit.ihotel.domains.administration.resources.UpdateEmployeeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;

    private final EmployeeMapper mapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper mapper) {
        this.employeeService = employeeService;
        this.mapper = mapper;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<EmployeeResource> createEmployee(@RequestBody SaveEmployeeResource resource) {
        return new ResponseEntity<>(mapper.toResource(employeeService.create(
                mapper.toModel(resource))) , HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("{employeeId}")
    public EmployeeResource updateEmployee(@PathVariable Long employeeId, @RequestBody UpdateEmployeeResource resource) {
        return mapper.toResource(employeeService.update(employeeId, mapper.toModel(resource)));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId) {
        return employeeService.delete(employeeId);
    }


}
