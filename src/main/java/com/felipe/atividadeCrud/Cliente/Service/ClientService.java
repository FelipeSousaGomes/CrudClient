package com.felipe.atividadeCrud.Cliente.Service;

import com.felipe.atividadeCrud.Cliente.Entity.Client;
import com.felipe.atividadeCrud.Cliente.dto.ClientDto;
import com.felipe.atividadeCrud.Cliente.exceptions.ResourceNotFoundException;
import com.felipe.atividadeCrud.Cliente.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @Transactional(readOnly = true)
    public Page<ClientDto> findAll(Pageable pageable){
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientDto(x));
    }

    @Transactional
    public ClientDto insert (ClientDto dto){
        Client entity = new Client();
        convertDtoEntity(dto,entity);
        entity = repository.save(entity);
        return new ClientDto(entity);
    }

    @Transactional
    public ClientDto update(Long id, ClientDto dto) {
        try {
            Client entity = repository.getReferenceById(id);
            convertDtoEntity(dto, entity);
            entity = repository.save(entity);
            return new ClientDto(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }


    private void convertDtoEntity(ClientDto dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }


}
