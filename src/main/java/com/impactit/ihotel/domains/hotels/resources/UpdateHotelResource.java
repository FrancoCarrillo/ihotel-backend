package com.impactit.ihotel.domains.hotels.resources;

import com.impactit.ihotel.domains.administration.domain.entities.Administrator;
import com.impactit.ihotel.domains.administration.domain.entities.Business;
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
public class UpdateHotelResource {
    private Long   id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    @NotBlank
    @Size
    private String address;
}
