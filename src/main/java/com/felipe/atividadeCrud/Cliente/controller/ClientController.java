package com.felipe.atividadeCrud.Cliente.controller;

import com.felipe.atividadeCrud.Cliente.Service.ClientService;
import com.felipe.atividadeCrud.Cliente.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;


    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable Long id){
        ClientDto dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }
}
