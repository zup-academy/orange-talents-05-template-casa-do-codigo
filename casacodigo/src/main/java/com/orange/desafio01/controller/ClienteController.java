package com.orange.desafio01.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import com.orange.desafio01.casacodigo.dto.ClienteRequest;
import com.orange.desafio01.casacodigo.dto.ClienteResponse;
import com.orange.desafio01.casacodigo.entity.Cliente;
import com.orange.desafio01.repository.ClienteRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;

    @PersistenceContext
    EntityManager manager;

    @PostMapping
    public ResponseEntity<ClienteResponse> adicionar(@RequestBody @Valid ClienteRequest clienteRequest) {
        Cliente cliente = clienteRequest.converterToCliente(manager);
        clienteRepository.save(cliente);

        return ResponseEntity.ok(new ClienteResponse(cliente));
    }
}
