package com.example.projetoGraphQl.Redes.modules.livros;

import java.util.UUID;

import com.example.projetoGraphQl.Redes.modules.clientes.ClientEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class BooksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String titulo;

    private String autor;

    private String genero;

    private float price;

    @ManyToOne()
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private ClientEntity client;

    @Column(name = "client_id")
    private UUID clientId;

    public BooksEntity(String titulo, float price, String autor, String genero, UUID clientId) {
        this.titulo = titulo;
        this.price = price;
        this.clientId = clientId;
    }
    
    
}
