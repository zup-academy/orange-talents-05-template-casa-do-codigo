package com.orange.desafio01.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import com.orange.desafio01.casacodigo.dto.EstadoRequest;
import com.orange.desafio01.casacodigo.entity.Estado;
import com.orange.desafio01.repository.EstadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    EstadoRepository estadoRepository;
    
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody @Valid EstadoRequest estadoRequest) {
        Estado estado = estadoRequest.conveterToEstado(manager);
        estadoRepository.save(estado);

        return ResponseEntity.ok().build();
    }
}
