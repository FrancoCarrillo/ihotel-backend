package com.impactit.ihotel.domains.administration.resources;


import lombok.*;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class SaveEmployeeResource {

    private String   name;
    private String dni;
    private String   phoneNumber;
    private String   type;

}
