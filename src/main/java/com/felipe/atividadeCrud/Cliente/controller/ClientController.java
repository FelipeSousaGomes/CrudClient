package com.felipe.atividadeCrud.Cliente.controller;

import com.felipe.atividadeCrud.Cliente.Service.ClientService;
import com.felipe.atividadeCrud.Cliente.dto.ClientDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @GetMapping
    public ResponseEntity<Page<ClientDto>> findById(Pageable pageable){
        Page<ClientDto> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ClientDto> insert(@Valid @RequestBody ClientDto dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDto> insert( @PathVariable Long id, @Valid @RequestBody ClientDto dto){
      dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Void> Update(@PathVariable Long id){
        service.Delete(id);
        return ResponseEntity.noContent().build();
    }


}
