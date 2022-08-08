package com.impactit.ihotel.domains.administration.controllers;

import com.impactit.ihotel.domains.administration.domain.entities.Administrator;
import com.impactit.ihotel.domains.administration.services.AdministratorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/administrators")
public class AdministratorController {
    @Autowired
    private AdministratorServiceImpl administratorService;

    public AdministratorController() {}

    @GetMapping
    public List<Administrator> getAll() {
        return administratorService.getAll();
    }

    @GetMapping("/{id}")
    public Administrator getById(@PathVariable Long id) {
        return administratorService.getById(id);
    }

    @PostMapping
    public Administrator create(@RequestBody Administrator administrator) {
        return administratorService.create(administrator);
    }
}
