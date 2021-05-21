package com.orange.desafio01.casacodigo.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.orange.desafio01.casacodigo.entity.Autor;

public class AutorRequest {

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    private LocalDateTime registro = LocalDateTime.now();
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public AutorRequest(
        @NotBlank String nome, 
        @NotBlank @Email String email,
        @NotBlank @Size(max = 400) String descricao) {
        super();
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor conveterToAutor () {
        return new Autor(this.nome, this.email, this.registro, this.descricao);
    }

    public String getEmail() {
        return this.email;
    }

}
