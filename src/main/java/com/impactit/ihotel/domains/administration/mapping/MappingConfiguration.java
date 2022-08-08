package com.impactit.ihotel.domains.administration.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("administrationMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public  EmployeeMapper employeeMapper() { return new EmployeeMapper(); }

}
