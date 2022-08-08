package com.impactit.ihotel.domains.reservations.mapping;

import com.impactit.ihotel.domains.reservations.domain.entities.Reservation;
import com.impactit.ihotel.domains.reservations.resource.ReservationRequestResource;
import com.impactit.ihotel.domains.reservations.resource.ReservationResource;
import com.impactit.ihotel.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.Mapping;

import java.io.Serializable;
import java.util.List;

public class ReservationMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public ReservationResource toResource(Reservation model){
        return mapper.map(model,ReservationResource.class);
    }

    public Page<ReservationResource> modelListPage(List<Reservation> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,ReservationResource.class),pageable,modelList.size());
    }

    public Reservation toModel(ReservationRequestResource resource){
        return mapper.map(resource,Reservation.class);
    }

}
