package com.impactit.ihotel.domains.reports.domain.services;
import com.impactit.ihotel.domains.reports.domain.entitities.Report;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReportService {
    List<Report> getAll();

    Report create(Report report);

    Report update(Long reportId, Report request);

    ResponseEntity<?> delete(Long reportId);

    Report getById(Long id);
}
