package casadocodigo.casadocodigo.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_autor")
public class Autor{



    @NotNull @NotBlank
    @Column(name = "NOME_AUTOR")
    private String nomeAutor;
    @Id
    @NotNull @NotBlank
    @Column(name = "EMAIL_AUTOR")
    private String emailAutor;
    @NotNull @NotBlank
    @Column(name = "DESC_AUTOR", length = 400)
    private String descAutor;
    @Column(name = "LOCAL")
    private LocalDateTime local;


    public Autor(String nomeAutor, String emailAutor, String descAutor, LocalDateTime local) {

        this.nomeAutor = nomeAutor;
        this.emailAutor = emailAutor;
        this.descAutor = descAutor;
        this.local = local;
    }


    public Autor(String nomeAutor, String emailAutor, String descAutor) {
        this.nomeAutor = nomeAutor;
        this.emailAutor = emailAutor;
        this.descAutor = descAutor;
    }

    public Autor() {
    }
}
