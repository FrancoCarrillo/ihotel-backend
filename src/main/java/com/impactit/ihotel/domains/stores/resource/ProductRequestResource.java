package com.impactit.ihotel.domains.stores.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestResource {

    private String name;
    private String brandName;
    private Float price;
}
