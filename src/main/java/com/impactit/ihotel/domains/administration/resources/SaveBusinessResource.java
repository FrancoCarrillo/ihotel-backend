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
public class SaveBusinessResource {
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String  name;

    @NotNull
    @NotBlank
    private String ruc;
}
