package com.impactit.ihotel.domains.administration.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.impactit.ihotel.domains.hotels.domain.entities.Hotel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@ToString
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 64, message = "Name must be between 2 and 64 characters")
    @Column(name = "name", nullable = false, length = 64)
    private String   name;

    @NotEmpty(message = "DNI cannot be empty")
    @Size(min = 8, max = 8, message = "DNI must have 8 characters")
    @Column(name = "dni", nullable = true, unique = true, length = 8)
    private String dni;

    @NotEmpty(message = "Phone cannot be empty")
    @Size(min = 9, max = 9, message = "Phone must have 9 characters")
    @Column(name = "phone_number", nullable = true, length = 9)
    private String   phoneNumber;

    @NotEmpty(message = "Type cannot be empty")
    @Size(min = 2, max = 64, message = "Type must have between 2 and 64 characters")
    @Column(name = "type", nullable = false, length = 64)
    private String   type;

}

