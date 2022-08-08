package com.impactit.ihotel.domains.reports.domain.persistence;
import com.impactit.ihotel.domains.reports.domain.entitities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    @Override
    List<Report> findAll();

    @Override
    Report getById(Long id);
}
