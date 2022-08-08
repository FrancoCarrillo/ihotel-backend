package com.impactit.ihotel.domains.administration.resources;

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
public class UpdateAdministratorResource {

    Long Id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String nickname;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String passwordHash;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String surname;

    private Date bornDate;

    @NotNull
    @NotBlank
    @Size(max = 9)
    private String phoneNumber;

    @NotNull
    @NotBlank
    private String address;
}
