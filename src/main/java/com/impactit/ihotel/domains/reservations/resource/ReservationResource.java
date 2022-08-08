package com.impactit.ihotel.domains.reservations.resource;

import com.impactit.ihotel.domains.guests.domain.entities.Client;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResource {
    //private Client clientId;
    private Long id;
    private Long clientId;
    private String status;
    private Date reservationDate ;
    private Date checkInDate;
}
