package com.impactit.ihotel.domains.reservations.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.impactit.ihotel.domains.stores.domain.entities.Purchase;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

class PurchasesPerReservationPrimaryKey implements Serializable {
	private Purchase    purchase;
	private Reservation reservation;
}

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@IdClass(PurchasesPerReservationPrimaryKey.class)
@Table(name = "purchases_per_product")
public class PurchasesPerReservation {

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "purchase_id", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ToString.Exclude
	private Purchase purchase;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reservation_id", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ToString.Exclude
	private Reservation reservation;
}
