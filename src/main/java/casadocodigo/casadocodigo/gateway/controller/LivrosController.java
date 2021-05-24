package casadocodigo.casadocodigo.gateway.controller;


import casadocodigo.casadocodigo.dtos.AutorDTO;
import casadocodigo.casadocodigo.dtos.CategoriaDTO;
import casadocodigo.casadocodigo.dtos.LivroDTO;
import casadocodigo.casadocodigo.entities.Autor;
import casadocodigo.casadocodigo.entities.Categoria;
import casadocodigo.casadocodigo.entities.Livro;
import casadocodigo.casadocodigo.gateway.repositories.AutorRepository;
import casadocodigo.casadocodigo.gateway.repositories.CategoriaRepository;
import casadocodigo.casadocodigo.gateway.repositories.LivrosRepository;
import casadocodigo.casadocodigo.util.validators.AutorValidator;
import casadocodigo.casadocodigo.util.validators.CategoriaValidator;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/livros")
public class LivrosController {


    @PersistenceContext
    EntityManager manager;

    private LivrosRepository livrosRepository;
    public LivrosController(LivrosRepository livrosRepository) {
        this.livrosRepository = livrosRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void cadastraLivro(@RequestBody @Valid LivroDTO request){

        Livro livro = request.toModel(manager);
        livrosRepository.save(livro);
    }


}
