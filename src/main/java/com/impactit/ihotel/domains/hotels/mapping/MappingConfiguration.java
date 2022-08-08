package com.impactit.ihotel.domains.hotels.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("HotelMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public HotelMapper hotelMapper() { return new HotelMapper(); }
    @Bean
    public RoomMapper roomMapper() { return new RoomMapper(); }
}
