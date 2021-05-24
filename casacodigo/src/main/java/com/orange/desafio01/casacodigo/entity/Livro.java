package com.orange.desafio01.casacodigo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @Lob
    private String sumario;
    @Min(20)
    private BigDecimal preco;
    @NotNull
    @Min(100)
    private Integer numeroPaginas;
    @NotBlank
    @Column(unique = true)
    private String isbn;
    @NotNull
    private LocalDate dataPublicacao;
    @NotNull
    @ManyToOne
    private Categoria categoria;
    @NotNull
    @ManyToOne
    private Autor autor;

    @Deprecated
    public Livro() {
    }

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
            @Min(20) BigDecimal preco, @NotNull @Min(100) Integer numeroPaginas, @NotBlank String isbn,
            @Future LocalDate dataPublicacao, @NotNull Autor autor, @NotNull Categoria categoria) {
                this.titulo = titulo;
                this.resumo = resumo;
                this.sumario = sumario;
                this.preco = preco;
                this.numeroPaginas = numeroPaginas;
                this.isbn = isbn;
                this.dataPublicacao = dataPublicacao;
                this.autor = autor;
                this.categoria = categoria;
    }

    public Long getId() {
        return this.id;
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

    public Categoria getCategoria() {
        return this.categoria;
    }

    public Autor getAutor() {
        return this.autor;
    }


}
