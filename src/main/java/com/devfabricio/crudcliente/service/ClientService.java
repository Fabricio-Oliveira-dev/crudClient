package com.devfabricio.crudcliente.service;

import com.devfabricio.crudcliente.dto.ClientDTO;
import com.devfabricio.crudcliente.entity.Client;
import com.devfabricio.crudcliente.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).get();
        return new ClientDTO(client);
    }
}
