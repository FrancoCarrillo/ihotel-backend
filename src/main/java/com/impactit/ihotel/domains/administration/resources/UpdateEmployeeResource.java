package com.impactit.ihotel.domains.administration.resources;

import com.impactit.ihotel.domains.administration.domain.entities.Employee;
import com.impactit.ihotel.domains.hotels.domain.entities.Hotel;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeResource {

    private String   name;
    private String dni;
    private String   phoneNumber;
    private String   type;

}
