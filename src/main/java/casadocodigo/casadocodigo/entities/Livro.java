package casadocodigo.casadocodigo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tb_livro")
public class Livro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLivro;

    @NotNull @NotBlank //Titulo é obrigatório
    @Column(name = "TITULO")
    private String titulo;

    @NotNull @NotBlank //Resumo é obrigatório
    @Column(name = "RESUMO")
    private String resumo;

    @NotNull @NotBlank //Sumário é de tamanho livre.
    @Column(name = "SUMARIO")
    private String sumario;

    @NotNull @NotBlank //Preço é obrigatório e o mínimo é de 20
    @Column(name = "PRECO")
    @Length(min = 20)
    private int preco;

    @NotNull @NotBlank //Número de páginas é obrigatória e o mínimo é de 100
    @Column(name = "NUMERO_PAGINAS")
    @Length(min = 100)
    private int numeroPaginas;

    @NotBlank @NotNull //Isbn é obrigatório, formato livre - Isbn é único
    @Column(name = "isbn")
    private String isbn;


    @Future
    @JsonFormat(pattern = "dd/mm/yyyy", shape = JsonFormat.Shape.STRING)
    @NotBlank @NotNull // Data que vai entrar no ar precisa ser no futuro
    @Column(name = "DATA_PUBLICACAO")
    private LocalDate data_publicacao;

    @ManyToOne
    @NotNull //A categoria não pode ser nula
    private long IdCategoria;

    @ManyToOne
    @NotNull //O autor não pode ser nulo
    private long IdAutor;



    public Livro(String titulo, String resumo, String sumario, int preco, int numero_paginas, String isbn, LocalDate data_publicacao, Categoria categoria, Autor autor) {
    }

    public Livro() {

    }

    @Override
    public String toString() {
        return "Livro{" +
                "idLivro=" + idLivro +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", data_publicacao=" + data_publicacao +
                ", IdCategoria=" + IdCategoria +
                ", IdAutor=" + IdAutor +
                '}';
    }

    public void setQuantidade(String valueOf) {
    }
}
