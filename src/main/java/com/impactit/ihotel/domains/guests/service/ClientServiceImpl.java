package com.impactit.ihotel.domains.guests.service;

import com.impactit.ihotel.domains.guests.domain.entities.Client;
import com.impactit.ihotel.domains.guests.domain.persistence.ClientRepository;
import com.impactit.ihotel.domains.guests.domain.service.ClientService;
import com.impactit.ihotel.shared.exception.ResourceNotFoundException;
import com.impactit.ihotel.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {

    private static final String ENTITY = "clients";


    @Autowired
    private final ClientRepository clientRepository;

    private final Validator validator;

    public ClientServiceImpl(ClientRepository clientRepository, Validator validator) {
        this.clientRepository = clientRepository;
        this.validator = validator;
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client create(Client client) {
        Set<ConstraintViolation<Client>> violations = validator.validate(client);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);


        return clientRepository.save(client);
    }

    @Override
    public Client update(Long clientId, Client request) {
        Set<ConstraintViolation<Client>> violations = validator.validate(request);
        if(!violations.isEmpty())
            throw  new ResourceValidationException(ENTITY, violations);

        return clientRepository.findById(clientId).map(client->
                clientRepository.save(client.withName(request.getName())
                        .withSurname(request.getSurname())
                        .withAddress(request.getAddress())
                        .withEmail(request.getEmail())
                        .withPhoneNumber(request.getPhoneNumber())
                        .withDni(request.getDni())))
                .orElseThrow(()->new ResourceNotFoundException(ENTITY, clientId));
    }

    @Override
    public ResponseEntity<?> delete(Long clientId) {
        return clientRepository.findById(clientId).map(client -> {
            clientRepository.delete(client);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, clientId));
    }
}
