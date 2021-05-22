package casadocodigo.casadocodigo.gateway.controller;

import casadocodigo.casadocodigo.dtos.CategoriaDTO;
import casadocodigo.casadocodigo.entities.Categoria;
import casadocodigo.casadocodigo.gateway.repositories.CategoriaRepository;
import casadocodigo.casadocodigo.util.validators.CategoriaValidator;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    private CategoriaRepository categoriaRepository;
    public CategoriaController(CategoriaRepository categoriaRepository) {this.categoriaRepository = categoriaRepository;}

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void cadastraCategoria(@RequestBody @Validated(CategoriaValidator.class) @Valid CategoriaDTO request){

        Categoria categoria = request.toModel();
        categoriaRepository.save(categoria);
    }
}
