package com.yuli.bootcamp.service;

import com.yuli.bootcamp.model.Client;
import com.yuli.bootcamp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ClientService {

    @Autowired
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Transactional
    public Client save(Client actualizoCliente) {
        return clientRepository.save(actualizoCliente);
    }


    public void getClientById(int id, Client newClient) {
              Optional<Client> client = clientRepository.findById();
    }
}
