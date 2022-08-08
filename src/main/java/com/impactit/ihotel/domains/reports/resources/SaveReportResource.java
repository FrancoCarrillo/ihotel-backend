package com.impactit.ihotel.domains.reports.resources;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class SaveReportResource {
    private Long purchasedProductsCount;
    private Long guestRegistered;
    private Date date;
    private Long reservedRooms;
    private Long totalAmountEarned;
}
