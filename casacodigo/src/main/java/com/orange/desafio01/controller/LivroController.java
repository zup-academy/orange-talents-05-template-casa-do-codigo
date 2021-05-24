package com.orange.desafio01.controller;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import com.orange.desafio01.casacodigo.dto.LivroRequest;
import com.orange.desafio01.casacodigo.dto.LivroResponse;
import com.orange.desafio01.casacodigo.entity.Livro;
import com.orange.desafio01.repository.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {
    
    @Autowired
    LivroRepository livroRepository;

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroRequest livroRequest) {
        Livro livro = livroRequest.converterToLivro(manager);

        livroRepository.save(livro);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponse> detalhesLivro(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);

        if(livro.isPresent()) {
            LivroResponse livroResponse = new LivroResponse(livro.get());

            return ResponseEntity.ok(livroResponse);
        }

        return ResponseEntity.notFound().build();
    }
}
