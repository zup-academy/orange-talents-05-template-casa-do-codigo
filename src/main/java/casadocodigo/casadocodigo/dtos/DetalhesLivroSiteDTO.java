package casadocodigo.casadocodigo.dtos;

import casadocodigo.casadocodigo.entities.Autor;
import casadocodigo.casadocodigo.entities.Livro;

import java.math.BigDecimal;

public class DetalhesLivroSiteDTO {

    private Autor autor;
    private String titulo;
    private String isbn;
    private int numeroPaginas;
    private BigDecimal preco;
    private String resumo;
    private String sumario;


    public DetalhesLivroSiteDTO(Livro livro) {

        titulo = livro.getTitulo();
        autor = livro.getAutor();
        isbn = livro.getIsbn();
        numeroPaginas = livro.getNumeroPaginas();
        preco = livro.getPreco();
    }

    public Autor getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }
}
