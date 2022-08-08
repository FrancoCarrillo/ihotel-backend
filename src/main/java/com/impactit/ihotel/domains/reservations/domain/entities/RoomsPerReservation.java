package com.impactit.ihotel.domains.reservations.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.impactit.ihotel.domains.hotels.domain.entities.Room;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

class RoomsPerReservationPrimaryKey implements Serializable {
	private Room        room;
	private Reservation reservation;
}

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@IdClass(RoomsPerReservationPrimaryKey.class)
@Table(name = "rooms_per_reservation")
public class RoomsPerReservation {

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ToString.Exclude
	private Room room;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reservation_id", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ToString.Exclude
	private Reservation reservation;
}
