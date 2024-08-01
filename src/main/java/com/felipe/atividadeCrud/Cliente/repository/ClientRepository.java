package com.felipe.atividadeCrud.Cliente.repository;

import com.felipe.atividadeCrud.Cliente.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

}
