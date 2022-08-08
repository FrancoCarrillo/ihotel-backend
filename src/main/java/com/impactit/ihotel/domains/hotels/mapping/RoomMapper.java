package com.impactit.ihotel.domains.hotels.mapping;

import com.impactit.ihotel.domains.hotels.domain.entities.Room;
import com.impactit.ihotel.domains.hotels.resources.RoomResource;
import com.impactit.ihotel.domains.hotels.resources.SaveRoomResource;
import com.impactit.ihotel.shared.mapping.EnhancedModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

@Slf4j
public class RoomMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public RoomResource toResource(Room model) {
        return mapper.map(model, RoomResource.class);
    }

    public Page<RoomResource> modelListPage(List<Room> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, RoomResource.class), pageable, modelList.size());
    }

    public Room toModel(SaveRoomResource resource) {
        return mapper.map(resource, Room.class);
    }
}
