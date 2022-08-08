package com.impactit.ihotel.domains.hotels.resources;


import com.impactit.ihotel.domains.hotels.domain.entities.Hotel;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class RoomResource {
    private Long id;
    private String  number;
    private Integer capacity;
    private String  type;
    private String  status;
    private Long hotelId;
}