package com.example.projetoGraphQl.Redes.modules.livros;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BooksController {

    @Autowired
    private BooksRepository booksRepository;

    @MutationMapping()
    BooksEntity addBooks(@Argument BooksInput booksInput){
        var caixaBooks = this.booksRepository.save(new BooksEntity(booksInput.titulo, booksInput.price, booksInput.autor, booksInput.genero, booksInput.clientId));
        return caixaBooks;
    }
    
    @QueryMapping()
    Iterable<BooksEntity> books(){
        var books = this.booksRepository.findAll();
        return books;
    }

    @QueryMapping
    Iterable<BooksEntity> booksByClientId(@Argument UUID clientId) {
        Iterable<BooksEntity> booksClient = this.booksRepository.findByClientId(clientId);
        return booksClient;
    }

    record BooksInput(String titulo, float price, String autor, String genero, UUID clientId){
    }
}
