package com.devfabricio.crudcliente.service;

import com.devfabricio.crudcliente.dto.ClientDTO;
import com.devfabricio.crudcliente.entity.Client;
import com.devfabricio.crudcliente.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).get();
        return new ClientDTO(client);
    }

    public Page<ClientDTO> findAllPaged(Pageable pageable) {
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client client = new Client();
        dtoToEntity(dto, client);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        Client client = clientRepository.getReferenceById(id);
        dtoToEntity(dto, client);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private static void dtoToEntity(ClientDTO dto, Client client) {
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setBirthDate(dto.getBirthDate());
        client.setChildren(dto.getChildren());
    }
}
