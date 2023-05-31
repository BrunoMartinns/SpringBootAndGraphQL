package com.example.projetoGraphQl.Redes.modules.clientes;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String cpf;

    private String cidade;

    private String uf;

    private String telefone;

    private String email;




    public ClientEntity(String name, String cpf, String cidade, String uf, String telefone, String email){
        this.name = name;
        this.cpf = cpf;
        this.cidade = cidade;
        this.uf = uf;
        this.telefone = telefone;
        this.email = email;
    }

    
}
