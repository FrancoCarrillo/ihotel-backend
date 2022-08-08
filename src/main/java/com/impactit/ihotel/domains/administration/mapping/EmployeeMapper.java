package com.impactit.ihotel.domains.administration.mapping;

import com.impactit.ihotel.domains.administration.domain.entities.Employee;
import com.impactit.ihotel.domains.administration.resources.EmployeeResource;
import com.impactit.ihotel.domains.administration.resources.SaveEmployeeResource;
import com.impactit.ihotel.domains.administration.resources.UpdateEmployeeResource;
import com.impactit.ihotel.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class EmployeeMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public EmployeeResource toResource(Employee model) {
        return mapper.map(model, EmployeeResource.class);
    }

    public Page<EmployeeResource> modelListPage(List<Employee> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, EmployeeResource.class), pageable, modelList.size());
    }

    public Employee toModel(SaveEmployeeResource resource) {
        return mapper.map(resource, Employee.class);
    }

    public Employee toModel(UpdateEmployeeResource resource) {
        return mapper.map(resource, Employee.class);
    }
}
