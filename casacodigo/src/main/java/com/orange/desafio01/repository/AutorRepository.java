package com.orange.desafio01.repository;

import com.orange.desafio01.casacodigo.entity.Autor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    
}
