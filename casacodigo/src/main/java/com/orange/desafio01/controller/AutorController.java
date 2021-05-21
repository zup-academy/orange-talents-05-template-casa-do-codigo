package com.orange.desafio01.controller;

import javax.validation.Valid;

import com.orange.desafio01.casacodigo.dto.AutorRequest;

import com.orange.desafio01.repository.AutorRepository;
import com.orange.desafio01.validator.ProibeEmailDuplicadoAutorValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.desafio01.casacodigo.entity.Autor;

@RestController
@RequestMapping("/autores")
public class AutorController {
    
    @Autowired
    private AutorRepository autorRepository;
    
    @Autowired
    private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(proibeEmailDuplicadoAutorValidator);
    }
    
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid AutorRequest autorRequest) {

        Autor autor = autorRequest.conveterToAutor();
        autorRepository.save(autor);

        return ResponseEntity.ok().build();
    }
}
