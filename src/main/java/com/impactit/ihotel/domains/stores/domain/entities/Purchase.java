package com.impactit.ihotel.domains.stores.domain.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

@Getter
@Setter
@With
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchases")
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@DecimalMin(value = "0.01", message = "Total must be greater than 0")
	@Digits(integer = 10, fraction = 2, message = "Total must be a number")
	@Column(name = "total", nullable = false)
	private Float total;
}
