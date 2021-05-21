package casadocodigo.casadocodigo.gateway.controller;

import casadocodigo.casadocodigo.dtos.AutorDTO;
import casadocodigo.casadocodigo.entities.Autor;
import casadocodigo.casadocodigo.gateway.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/autor")
public class AutorController{

    private AutorRepository autorRepository;
    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }



    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void cadastraAutor(@RequestBody @Valid AutorDTO request){

        Autor autor = request.toModel();
        autorRepository.save(autor);
    }

}
