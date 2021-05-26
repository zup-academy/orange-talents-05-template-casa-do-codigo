package com.orange.desafio01.casacodigo.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email @NotBlank
    @Column(nullable = false) private String email;
    @NotBlank
    @Column(nullable = false) private String nome;
    @NotBlank
    @Column(nullable = false) private String sobrenome;
    @NotBlank
    @Column(nullable = false) private String documento;
    @NotBlank
    @Column(nullable = false) private String endereco;
    @NotBlank
    @Column(nullable = false) private String complemento;
    @NotBlank
    @Column(nullable = false) private String cidade;
    @NotNull
    @ManyToOne @JoinColumn(name = "pais_id", nullable = false) private Pais pais;
    @ManyToOne @JoinColumn(name = "estado_id", nullable = true) private Estado estado;
    @NotBlank
    @Column(nullable = false) private String telefone;
    @NotBlank
    @Column(nullable = false) private String cep;

    public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
            @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
            @NotBlank String cidade, Pais pais, @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }



}
