package com.impactit.ihotel.domains.guests.controllers;

import com.impactit.ihotel.domains.guests.domain.service.ClientService;

import com.impactit.ihotel.domains.guests.mapping.ClientMapper;
import com.impactit.ihotel.domains.guests.resource.ClientResource;
import com.impactit.ihotel.domains.guests.resource.ClientRequestResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/clients")
public class ClientController {

    @Autowired
    private final ClientService clientService;

    private final ClientMapper mapper;

    public ClientController(ClientService clientService, ClientMapper mapper) {
        this.clientService = clientService;
        this.mapper = mapper;
    }
    @CrossOrigin(origins = "*")
    @GetMapping
    public Page<ClientResource> getAllGuest(Pageable pageable){
        return mapper.modelListPage(clientService.getAll(), pageable);
    }
    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<ClientResource> createClient(@RequestBody ClientRequestResource resource) {
        return new ResponseEntity<>(mapper.toResource(clientService.create(
                mapper.toModel(resource))), HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("{clientId}")
    public ClientResource updateClientP( @PathVariable Long clientId,@RequestBody ClientRequestResource resource){
        return mapper.toResource(clientService.update(clientId, mapper.toModel(resource)));
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable Long clientId) {
        return clientService.delete(clientId);
    }
}
