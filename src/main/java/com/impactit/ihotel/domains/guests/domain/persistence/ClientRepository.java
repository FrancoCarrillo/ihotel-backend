package com.impactit.ihotel.domains.guests.domain.persistence;

import com.impactit.ihotel.domains.guests.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Override
    List<Client> findAll();

    Client findByName(String Name); //Select * from tabla Where name = ?

    Client findAllById(Long id);
}
