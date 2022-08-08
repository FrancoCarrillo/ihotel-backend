package com.impactit.ihotel.domains.stores.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class BenefitResource {

    private Long id;
    private String name;
    private Float price;
}
