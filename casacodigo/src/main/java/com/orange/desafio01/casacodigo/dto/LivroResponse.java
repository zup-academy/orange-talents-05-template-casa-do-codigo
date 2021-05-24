package com.orange.desafio01.casacodigo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.orange.desafio01.casacodigo.entity.Livro;

public class LivroResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private AutorResponse autorResponse;


    public LivroResponse(Livro livro) {        
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.autorResponse = new AutorResponse(livro.getAutor());
    }


    public String getTitulo() {
        return this.titulo;
    }

    public String getResumo() {
        return this.resumo;
    }

    public String getSumario() {
        return this.sumario;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    public Integer getNumeroPaginas() {
        return this.numeroPaginas;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public LocalDate getDataPublicacao() {
        return this.dataPublicacao;
    }

    public AutorResponse getAutorResponse() {
        return this.autorResponse;
    }


}
