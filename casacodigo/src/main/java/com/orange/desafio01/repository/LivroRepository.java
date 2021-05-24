package com.orange.desafio01.repository;

import com.orange.desafio01.casacodigo.entity.Livro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    
}
