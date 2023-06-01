package com.example.projetoGraphQl.Redes.modules.livros;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;


public interface BooksRepository extends CrudRepository<BooksEntity, UUID> {

    Iterable<BooksEntity> findByClientId(UUID clientId);


    
}
