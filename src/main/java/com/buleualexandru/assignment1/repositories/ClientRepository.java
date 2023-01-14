package com.buleualexandru.assignment1.repositories;

import com.buleualexandru.assignment1.entitys.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {




    Optional<Client> findByNameAndPassword(String name, String password);
}
