package com.orange.desafio01.casacodigo.dto;

import com.orange.desafio01.casacodigo.entity.Cliente;

public class ClienteResponse {

    private Long id;

    public ClienteResponse(Cliente cliente) {
        this.id = cliente.getId();
    }

    public Long getId() {
        return id;
    }

}
