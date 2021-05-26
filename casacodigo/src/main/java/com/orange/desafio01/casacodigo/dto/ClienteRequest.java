package com.orange.desafio01.casacodigo.dto;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.orange.desafio01.casacodigo.compartilhado.CPForCNPJ;
import com.orange.desafio01.casacodigo.compartilhado.ExistId;
import com.orange.desafio01.casacodigo.compartilhado.UniqueValue;
import com.orange.desafio01.casacodigo.entity.Cliente;
import com.orange.desafio01.casacodigo.entity.Estado;
import com.orange.desafio01.casacodigo.entity.Pais;


public class ClienteRequest {

    @NotBlank
    @Email
    @UniqueValue(entidade = Cliente.class, fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @UniqueValue(entidade = Cliente.class, fieldName = "documento")
    @CPForCNPJ(message = "É preciso adicionar um cpf ou cnpj valido")
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ExistId(entidade = Pais.class)
    private Long pais_id;

    private Long estado_id;
    
    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public ClienteRequest(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Long pais_id, Long estado_id, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais_id = pais_id;
        this.estado_id = estado_id;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente converterToCliente(EntityManager manager) {
        Pais pais = manager.find(Pais.class, pais_id);
        Estado estado = manager.find(Estado.class, estado_id);

        Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep);

        if(estado != null) cliente.setEstado(estado);

        return cliente;
    }

    // public Cliente converterToCliente(EntityManager em) {
    //     @NotNull Pais pais = em.find(Pais.class, pais_id);
    //     Optional<Estado> estado = em.find(Estado.class, estado_id);

    //     
    // }

    

}