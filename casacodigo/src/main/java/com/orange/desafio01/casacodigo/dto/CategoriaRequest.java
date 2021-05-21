package com.orange.desafio01.casacodigo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.orange.desafio01.casacodigo.entity.Categoria;

public class CategoriaRequest {
    @NotBlank
    @Size(min = 3)
    private String nome;


    public CategoriaRequest(@NotBlank @Size(min = 3) String nome) {
        super();
        this.nome = nome;
    }

    public Categoria conveterToCategoria() {
        return new Categoria(this.nome);
    }

}
