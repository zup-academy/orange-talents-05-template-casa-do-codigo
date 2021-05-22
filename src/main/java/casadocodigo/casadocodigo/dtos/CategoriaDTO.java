package casadocodigo.casadocodigo.dtos;

import casadocodigo.casadocodigo.entities.Categoria;
import javax.validation.constraints.NotBlank;

public class CategoriaDTO {

    @NotBlank
    private String nomeCategoia;

    public CategoriaDTO(String nomeCategoia) {
        this.nomeCategoia = nomeCategoia;
    }

    public Categoria toModel() {

        return new Categoria(this.nomeCategoia);
    }
}
