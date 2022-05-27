package com.yuli.bootcamp.controller;


import com.yuli.bootcamp.model.Client;
import com.yuli.bootcamp.repository.ClientRepository;
import com.yuli.bootcamp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping(path = "/listaClientes")
    public List<Client> getClients(){
        return clientService.getClients();
    }


    @PostMapping (path = "/addClient", consumes = "application/json", produces = "application/json")
    public Client addClient(@RequestBody Client newClient){
        return clientService.addClient(newClient);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable Long id) {
    clientService.deleteClient(id);
    }

    //Obtengo un cliente a partir de un id
    @GetMapping(path = "/{id}")
    public Client getClientById(@PathVariable("id") int id){
        ClientRepository clientRepository = null;
        return clientRepository.findById(id);
    }

    //Actualizo un cliente a partir del id
    @PutMapping(path = "/actualizo/{id}")
    public Client updateClientById(@PathVariable("id") int id) {
        ClientRepository clientRepository = null;
        Client client = clientRepository.findById(id);
        return client;
   }

    //Actualizo un cliente desde el cuerpo de la petición
    @PutMapping(path = "/actualizo/Body", consumes = "application/json", produces = "application/json")
    public Client updateClient(@RequestBody Client actualizoCliente) {
        return clientService.save(actualizoCliente);
    }


}
