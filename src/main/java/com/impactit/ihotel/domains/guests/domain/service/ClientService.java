package com.impactit.ihotel.domains.guests.domain.service;

import com.impactit.ihotel.domains.guests.domain.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


import java.util.List;


public interface ClientService {
    List<Client> getAll();

    Client create(Client client);

    Client update(Long studentId, Client request);

    ResponseEntity<?> delete(Long studentId);
}
