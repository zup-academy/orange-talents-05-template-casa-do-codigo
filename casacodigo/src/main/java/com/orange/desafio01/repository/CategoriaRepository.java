package com.orange.desafio01.repository;

import com.orange.desafio01.casacodigo.entity.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
