package com.orange.desafio01.casacodigo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.orange.desafio01.casacodigo.compartilhado.UniqueValue;
import com.orange.desafio01.casacodigo.entity.Categoria;

public class CategoriaRequest {
    @NotBlank
    @Size(min = 3)
    @UniqueValue(entidade = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
