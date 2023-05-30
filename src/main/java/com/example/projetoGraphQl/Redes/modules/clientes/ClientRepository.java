package com.example.projetoGraphQl.Redes.modules.clientes;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity, UUID> {
    
}
