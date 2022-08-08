package com.impactit.ihotel.domains.guests.resource;

import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestResource {

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String address;

    private String dni;

}
