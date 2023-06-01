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
        ClientEntity newClient = this.clientRepository.save(new ClientEntity(client.name, client.cpf, client.cidade, client.uf, client.telefone, client.email));
        return newClient;
    }

    @QueryMapping()
    Optional<ClientEntity> clientById(@Argument UUID id){
        Optional<ClientEntity> clientes = this.clientRepository.findById(id);
        return clientes;
    }

    @QueryMapping()
    Iterable<ClientEntity> clients(){
        var clientes = this.clientRepository.findAll();
        return clientes;
    }


    record ClientInput(String name, String cpf , String cidade, String uf, String telefone, String email) {
    }


}
