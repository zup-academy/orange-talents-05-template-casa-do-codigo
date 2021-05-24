package casadocodigo.casadocodigo.dtos;

import casadocodigo.casadocodigo.entities.Autor;
import casadocodigo.casadocodigo.util.validators.UniqueValue;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorDTO {

    @NotBlank
    private String nomeAutor;

    @NotBlank
    @UniqueValue(domainClass = Autor.class, fieldName = "emailAutor")
    private String emailAutor;
    @NotBlank
    @Size(max=400)
    private String descAutor;

    public AutorDTO(@NotBlank String nomeAutor, @NotBlank @Email String emailAutor, @NotBlank @Size(max=400) String descAutor) {
        super();
        this.nomeAutor = nomeAutor;
        this.emailAutor = emailAutor;
        this.descAutor = descAutor;
    }

    public Autor toModel() {
        return new Autor(this.nomeAutor, this.emailAutor, this.descAutor);
    }


    public String getEmailAutor() {
        return emailAutor;
    }


}
