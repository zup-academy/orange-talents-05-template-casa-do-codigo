package com.orange.desafio01.casacodigo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoriaRequest {
    @NotBlank
    @Size(min = 3)
    private String nome;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
