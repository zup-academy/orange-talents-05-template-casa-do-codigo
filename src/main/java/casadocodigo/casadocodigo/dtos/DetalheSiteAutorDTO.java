package casadocodigo.casadocodigo.dtos;

import casadocodigo.casadocodigo.entities.Autor;

public class DetalheSiteAutorDTO {

    private String nomeAutor;
    private String descAutor;

    public DetalheSiteAutorDTO(Autor autor) {
        nomeAutor = autor.getNomeAutor();
        descAutor = autor.getDescricao();

    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getDescAutor() {
        return descAutor;
    }
}
