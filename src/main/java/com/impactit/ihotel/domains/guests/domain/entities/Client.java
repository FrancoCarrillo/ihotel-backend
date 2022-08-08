package com.impactit.ihotel.domains.guests.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.impactit.ihotel.domains.guests.domain.service.ClientService;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.*;


@Getter
@Setter
@With
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty(message = "Name cannot be empty")
	@Size(min = 2, max = 64, message = "Name must have between 2 and 64 characters")
	@Column(name = "name", nullable = false, length = 64)
	private String name;

	@NotEmpty(message = "Surname cannot be empty")
	@Size(min = 2, max = 64, message = "Surname must have between 2 and 64 characters")
	@Column(name = "surname", nullable = false, length = 64)
	private String surname;

	@NotEmpty(message = "Email cannot be empty")
	@Email(message = "Invalid email.")
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@NotEmpty(message = "Phone cannot be empty")
	@Size(min = 9, max = 9, message = "Phone must have 9 characters")
	@Column(name = "phone_number", nullable = true, length = 9)
	private String phoneNumber;

	@NotEmpty(message = "Address cannot be empty")
	@Size(min = 2, max = 128, message = "Address must have between 2 and 128 characters")
	@Column(name = "address", nullable = true, length = 128)
	private String address;

	@NotEmpty(message = "DNI cannot be empty")
	@Size(min = 8, max = 8, message = "DNI must have 8 characters")
	@Column(name = "dni", nullable = true, unique = true, length = 8)
	private String dni;

	public Client(Long id){
		this.id = id;

	}
}
