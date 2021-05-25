package com.orange.desafio01.casacodigo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.orange.desafio01.casacodigo.compartilhado.ExistId;
import com.orange.desafio01.casacodigo.compartilhado.UniqueValue;
import com.orange.desafio01.casacodigo.entity.Autor;
import com.orange.desafio01.casacodigo.entity.Categoria;
import com.orange.desafio01.casacodigo.entity.Livro;
import com.orange.desafio01.repository.AutorRepository;
import com.orange.desafio01.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class LivroRequest {
    @Autowired
    AutorRepository autorRepository;
    @Autowired
    CategoriaRepository categoriaRepository;

    @NotBlank
    @UniqueValue(entidade = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @Min(20)
    private BigDecimal preco;
    @NotNull
    @Min(100)
    private Integer numeroPaginas;
    @NotBlank
    @UniqueValue(entidade = Livro.class, fieldName = "isbn")
    private String isbn;
    @Future
    @JsonFormat(pattern = "dd/MM/yyy", shape = Shape.STRING )
    private LocalDate dataPublicacao;
    @NotNull
    @ExistId(entidade = Categoria.class)
    private Long categoria_id;
    @NotNull
    @ExistId(entidade = Autor.class)
    private Long autor_id;


    public LivroRequest(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroPaginas, String isbn, Long categoria_id, Long autor_id) {
        super();
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.categoria_id = categoria_id;
        this.autor_id = autor_id;
    }

    /**
     * Esse setter foi criado porque o jackson nao esta sendo capaz de desserealizar
     * o jason com a data no poarametro com construtor
     * @param dataPublicacao
     */
    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Livro converterToLivro(EntityManager em) {
        @NotNull Autor autor = em.find(Autor.class, autor_id);
        @NotNull Categoria categoria = em.find(Categoria.class, categoria_id);

        return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, autor, categoria);
    }
}
