package casadocodigo.casadocodigo.dtos;

import casadocodigo.casadocodigo.entities.Autor;
import casadocodigo.casadocodigo.util.validators.Email;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorDTO {

    @NotBlank
    private String nomeAutor;

    public String getEmailAutor() {
        return emailAutor;
    }

    @Email
    @NotBlank
    private String emailAutor;
    @NotBlank
    @Size(max=400)
    private String descAutor;

    public AutorDTO(@NotBlank String nomeAutor, @NotBlank String emailAutor, @NotBlank @Size(max=400) String descAutor) {
        super();
        this.nomeAutor = nomeAutor;
        this.emailAutor = emailAutor;
        this.descAutor = descAutor;
    }

    public Autor toModel() {
        return new Autor(this.nomeAutor, this.emailAutor, this.descAutor);
    }




}
