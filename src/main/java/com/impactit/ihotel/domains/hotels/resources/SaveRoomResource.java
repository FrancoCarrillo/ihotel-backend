package com.impactit.ihotel.domains.hotels.resources;

import com.impactit.ihotel.domains.hotels.domain.entities.Hotel;
import com.impactit.ihotel.domains.hotels.domain.entities.Room;
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
public class SaveRoomResource {
    private String  number;
    private Integer capacity;
    private String  type;
    private String  status;
    private Hotel hotelId;
}
