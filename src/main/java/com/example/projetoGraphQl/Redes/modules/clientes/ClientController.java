package com.example.projetoGraphQl.Redes.modules.clientes;

import java.util.NoSuchElementException;
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

    @MutationMapping()
    ClientEntity updateClientEntity(@Argument UUID id, @Argument ClientInput client){
        Optional<ClientEntity> clientes = this.clientRepository.findById(id);
        if (clientes.isPresent()) {
            ClientEntity clientEntity = clientes.get();
            clientEntity.setName(client.name);
            clientEntity.setCpf(client.cpf);
            clientEntity.setEmail(client.email);
            clientEntity.setTelefone(client.telefone);
            clientEntity.setCidade(client.cidade);
            clientEntity.setUf(client.uf);
            return clientRepository.save(clientEntity);
        } else {
            throw new NoSuchElementException("Cliente não encontrado");
        }
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
