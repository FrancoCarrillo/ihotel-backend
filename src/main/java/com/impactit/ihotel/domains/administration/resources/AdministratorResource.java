package com.impactit.ihotel.domains.administration.resources;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AdministratorResource {
    private Long   id;

    private String nickname;

    private String email;

    private String passwordHash;

    private String name;

    private String surname;

    private Date bornDate;

    private String phoneNumber;

    private String address;
}
