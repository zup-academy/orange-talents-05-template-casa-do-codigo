package com.orange.desafio01.casacodigo.dto;

import javax.validation.constraints.NotBlank;

import com.orange.desafio01.casacodigo.compartilhado.UniqueValue;
import com.orange.desafio01.casacodigo.entity.Pais;

public class PaisRequest {

    @NotBlank
    @UniqueValue(entidade = Pais.class, fieldName = "nome")
    private String nome;


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
