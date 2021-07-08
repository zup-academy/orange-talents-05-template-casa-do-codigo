package com.orange.desafio01.casacodigo.dto;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.orange.desafio01.casacodigo.compartilhado.ExistId;
import com.orange.desafio01.casacodigo.compartilhado.UniqueValueToUniqueId;
import com.orange.desafio01.casacodigo.entity.Estado;
import com.orange.desafio01.casacodigo.entity.Pais;

@UniqueValueToUniqueId(message = "Não pode haver estados repetidos para o mesmo pais")
public class EstadoRequest {
    @NotBlank  
    private String nome;

    @NotNull
    @ExistId(entidade = Pais.class)
    private Long pais_id;

    public EstadoRequest(String nome, Long pais_id) {
        this.nome = nome;
        this.pais_id = pais_id;
    }

    public Estado conveterToEstado (EntityManager em) {
        Pais pais = em.find(Pais.class, pais_id);
        return new Estado(this.nome, pais);
    }

    public String getNome() {
        return this.nome;
    }

    public Long getPais_id() {
        return this.pais_id;
    }

}
