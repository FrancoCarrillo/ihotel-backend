package com.impactit.ihotel.domains.hotels.mapping;

import com.impactit.ihotel.domains.hotels.domain.entities.Hotel;
import com.impactit.ihotel.domains.hotels.resources.HotelResource;
import com.impactit.ihotel.domains.hotels.resources.SaveHotelResource;
import com.impactit.ihotel.shared.mapping.EnhancedModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

@Slf4j
public class HotelMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public HotelResource toResource(Hotel model) {
        return mapper.map(model, HotelResource.class);
    }

    public Page<HotelResource> modelListPage(List<Hotel> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, HotelResource.class), pageable, modelList.size());
    }

    public Hotel toModel(SaveHotelResource resource) {
        mapper.getConfiguration().setAmbiguityIgnored(true);
        return mapper.map(resource, Hotel.class);
    }
}
