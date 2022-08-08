package com.impactit.ihotel.domains.hotels.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    @NotEmpty(message = "Number cannot be empty")
    @Size(min = 2, max = 64, message = "Number must be between 2 and 64 characters")
    @Column(name = "number", nullable = false, length = 64)
    private String  number;
    @Min(value = 1, message = "Capacity must be greater than 0")
    @Max(value = 32, message = "Capacity must be less than 32")
    @Column(name = "capacity", nullable = false)
    private Integer capacity;
    @NotEmpty(message = "Type cannot be empty")
    @Size(min = 2, max = 64, message = "Type must be between 2 and 64 characters")
    @Column(name = "type", nullable = false, length = 64)
    private String  type;
    @NotEmpty(message = "Status cannot be empty")
    @Size(min = 2, max = 64, message = "Status must be between 2 and 64 characters")
    @Column(name = "status", nullable = false, length = 64)
    private String  status;
    @OneToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    private Hotel hotel;
}

