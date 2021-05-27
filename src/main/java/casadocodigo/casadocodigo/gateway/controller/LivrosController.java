package casadocodigo.casadocodigo.gateway.controller;

import casadocodigo.casadocodigo.entities.Livro;
import casadocodigo.casadocodigo.gateway.repositories.LivrosRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping
    public List<LivroDTO> lista(String titulo) {
        if (titulo == null) {
            List<Livro> livro = livrosRepository.findAll();
            return LivroDTO.converter(livro);
        } else {
            List<Livro> livro = livrosRepository.findByTitulo(titulo);
            return LivroDTO.converter(livro);
        }
    }


}
