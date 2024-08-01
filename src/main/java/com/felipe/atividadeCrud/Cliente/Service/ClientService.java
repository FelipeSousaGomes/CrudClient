package com.felipe.atividadeCrud.Cliente.Service;

import com.felipe.atividadeCrud.Cliente.Entity.Client;
import com.felipe.atividadeCrud.Cliente.dto.ClientDto;
import com.felipe.atividadeCrud.Cliente.exceptions.ResourceNotFoundException;
import com.felipe.atividadeCrud.Cliente.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;


    @Transactional(readOnly = true)
    public ClientDto findById(Long id){
        Client client = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Recurso não encontrado"));
        return new ClientDto(client);
    }



}
