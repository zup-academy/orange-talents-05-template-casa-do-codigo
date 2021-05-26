package com.orange.desafio01.repository;

import com.orange.desafio01.casacodigo.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
