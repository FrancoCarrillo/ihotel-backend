package com.impactit.ihotel.domains.administration.resources;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class BusinessResource {

    Long id;

    private String  name;

    private String ruc;
}
