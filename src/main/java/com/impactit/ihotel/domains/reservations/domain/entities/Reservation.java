package com.impactit.ihotel.domains.reservations.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.impactit.ihotel.domains.guests.domain.entities.Client;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@With
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ToString.Exclude
	private Client clientId;

	@NotEmpty(message = "Status cannot be empty")
	@Size(min = 2, max = 64, message = "Status must be between 2 and 64 characters")
	@Column(name = "status", nullable = false, length = 64)
	private String  status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reservation_date", nullable = false)
	private Date reservationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "check_in_Date", nullable = false)
	private Date checkInDate;
}
