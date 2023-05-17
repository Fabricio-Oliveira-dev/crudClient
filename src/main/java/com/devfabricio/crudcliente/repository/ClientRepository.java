package com.devfabricio.crudcliente.repository;

import com.devfabricio.crudcliente.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
