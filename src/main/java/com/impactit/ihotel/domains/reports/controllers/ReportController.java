package com.impactit.ihotel.domains.reports.controllers;
import com.impactit.ihotel.domains.reports.domain.entitities.Report;
import com.impactit.ihotel.domains.reports.domain.services.ReportService;
import com.impactit.ihotel.domains.reports.mapping.ReportMapper;
import com.impactit.ihotel.domains.reports.resources.ReportResource;
import com.impactit.ihotel.domains.reports.resources.SaveReportResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/reports")
public class ReportController {
    @Autowired
    private final ReportService reportsService;

    public ReportController(ReportService reportsService) {
        this.reportsService = reportsService;
    }

    @GetMapping
    public List<Report> getAll() {
        return reportsService.getAll();
    }

    @PostMapping
    public Report create(@RequestBody Report resource) {
       return this.reportsService.create(resource);
    }
}
