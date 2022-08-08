package com.impactit.ihotel.domains.administration.domain.persistence;

import com.impactit.ihotel.domains.administration.domain.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    @Override
    List<Administrator> findAll();

    Administrator findByNickname(String nickName);

    @Override
    Administrator getById(Long id);
}
