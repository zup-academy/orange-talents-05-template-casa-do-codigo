package com.orange.desafio01.controller;

import javax.validation.Valid;

import com.orange.desafio01.casacodigo.dto.CategoriaRequest;
import com.orange.desafio01.casacodigo.entity.Categoria;
import com.orange.desafio01.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;
    
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaRequest categoriaRequest) {

        Categoria categoria = categoriaRequest.conveterToCategoria();
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().body(categoria);
    }
}
