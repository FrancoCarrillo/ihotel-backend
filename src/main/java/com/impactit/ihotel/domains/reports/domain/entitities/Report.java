package com.impactit.ihotel.domains.reports.domain.entitities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.impactit.ihotel.domains.administration.domain.entities.Administrator;
import com.impactit.ihotel.domains.administration.domain.entities.Business;
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
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;

    @Column(name = "purchased_product_count", nullable = false)
    private Long purchasedProductsCount;

    @Column(name = "guest_registered", nullable = true, length = 128)
    private Long guestRegistered;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "reserved_rooms", nullable = false)
    private Long reservedRooms;

    @Column(name = "total_amount_earned", nullable = false)
    private Long totalAmountEarned;
}
