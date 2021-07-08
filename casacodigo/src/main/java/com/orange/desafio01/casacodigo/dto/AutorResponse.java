package com.orange.desafio01.casacodigo.dto;

import com.orange.desafio01.casacodigo.entity.Autor;

public class AutorResponse {
    private String nome;
    private String descricao;

    public AutorResponse(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

}
