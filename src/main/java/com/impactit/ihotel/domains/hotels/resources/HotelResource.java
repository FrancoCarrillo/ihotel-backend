package com.impactit.ihotel.domains.hotels.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.impactit.ihotel.domains.administration.domain.entities.Administrator;
import com.impactit.ihotel.domains.administration.domain.entities.Business;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class HotelResource {
    private Long   id;

    private String name;

    private String address;
}
