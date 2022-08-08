package com.impactit.ihotel.domains.hotels.resources;

import com.impactit.ihotel.domains.hotels.domain.entities.Hotel;
import com.impactit.ihotel.domains.hotels.domain.entities.Room;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class UpdateRoomResource {
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 9)
    private String  number;

    @NotNull
    @NotBlank
    private Integer capacity;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String  type;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String  status;

}
