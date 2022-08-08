package com.impactit.ihotel.domains.reports.mapping;

import com.impactit.ihotel.domains.hotels.domain.entities.Hotel;
import com.impactit.ihotel.domains.hotels.resources.HotelResource;
import com.impactit.ihotel.domains.hotels.resources.SaveHotelResource;
import com.impactit.ihotel.domains.reports.domain.entitities.Report;
import com.impactit.ihotel.domains.reports.resources.ReportResource;
import com.impactit.ihotel.domains.reports.resources.SaveReportResource;
import com.impactit.ihotel.shared.mapping.EnhancedModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

@Slf4j
public class ReportMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public ReportResource toResource(Report model) {
        return mapper.map(model, ReportResource.class);
    }

    public Page<ReportResource> modelListPage(List<Report> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ReportResource.class), pageable, modelList.size());
    }

    public Report toModel(SaveReportResource resource) {
        mapper.getConfiguration().setAmbiguityIgnored(true);
        return mapper.map(resource, Report.class);
    }
}
