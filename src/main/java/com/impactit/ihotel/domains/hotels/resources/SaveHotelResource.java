package com.impactit.ihotel.domains.hotels.resources;

import com.impactit.ihotel.domains.administration.domain.entities.Administrator;
import com.impactit.ihotel.domains.administration.domain.entities.Business;
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
public class SaveHotelResource {
    private Business businessId;
    private Administrator administratorId;
    private String name;
    private String address;
}
