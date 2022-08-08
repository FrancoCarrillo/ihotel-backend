package com.impactit.ihotel.domains.stores.domain.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products", uniqueConstraints = {
		@UniqueConstraint(name="BrandProductNameConstrain", columnNames = {"brand_name", "name"})
})
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty(message = "Name cannot be empty")
	@Size(min = 2, max = 64, message = "Name must be between 2 and 64 characters")
	@Column(name = "name", nullable = false, length = 64)
	private String name;

	@NotEmpty(message = "Brand Name cannot be empty")
	@Size(min = 2, max = 64, message = "Brand Name must be between 2 and 64 characters")
	@Column(name = "brand_name", nullable = false, length = 64)
	private String brandName;

	@DecimalMin(value = "0.01", message = "Price must be greater than 0")
	@Digits(integer = 10, fraction = 2, message = "Price must be a number")
	@Column(name = "price", nullable = false)
	private Float price;

}
