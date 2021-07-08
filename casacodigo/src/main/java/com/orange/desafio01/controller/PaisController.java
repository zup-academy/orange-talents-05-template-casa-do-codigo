package com.orange.desafio01.controller;

import javax.validation.Valid;

import com.orange.desafio01.casacodigo.dto.PaisRequest;
import com.orange.desafio01.casacodigo.entity.Pais;
import com.orange.desafio01.repository.PaisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    PaisRepository paisRepository;
    
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid PaisRequest paisRequest) {
        Pais pais = new Pais(paisRequest.getNome());
        paisRepository.save(pais);
        return ResponseEntity.ok().build();
    }
}
