package com.orange.desafio01.casacodigo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    @Email
    private String email;

    private LocalDateTime registro;
    
    @Size(max = 400)
    private String descricao;

    @Deprecated
    public Autor() {
    }

    public Autor(String nome, String email, LocalDateTime registro, String descricao) {
        this.nome = nome;
        this.email = email;
        this.registro = registro;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}