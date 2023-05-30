package com.example.projetoGraphQl.Redes.modules.clientes;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @MutationMapping()
    ClientEntity addClient(@Argument ClientInput client){
        ClientEntity newClient = this.clientRepository.save(new ClientEntity(client.name));
        return newClient;
    }

    @QueryMapping()
    Optional<ClientEntity> clientById(@Argument UUID id){
        Optional<ClientEntity> clientes = this.clientRepository.findById(id);
        return clientes;
    }


    record ClientInput(String name) {
    }


}
