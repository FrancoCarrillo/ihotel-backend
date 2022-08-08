package com.impactit.ihotel.domains.administration.resources;


import lombok.*;



@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResource {
    private Long   id;
    private String   name;
    private String dni;
    private String   phoneNumber;
    private String   type;

}
