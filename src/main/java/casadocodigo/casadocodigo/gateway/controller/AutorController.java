package casadocodigo.casadocodigo.gateway.controller;

import casadocodigo.casadocodigo.dtos.AutorDTO;
import casadocodigo.casadocodigo.entities.Autor;
import casadocodigo.casadocodigo.gateway.repositories.AutorRepository;
import casadocodigo.casadocodigo.util.validators.AutorValidator;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/autores")
public class AutorController{

    private AutorRepository autorRepository;
    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }



    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void cadastraAutor(@RequestBody @Validated(AutorValidator.class) @Valid AutorDTO request){

        Autor autor = request.toModel();
        autorRepository.save(autor);
    }

}
