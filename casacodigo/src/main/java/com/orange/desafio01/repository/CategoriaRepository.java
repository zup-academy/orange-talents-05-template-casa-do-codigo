package com.orange.desafio01.repository;

import java.util.Optional;

import com.orange.desafio01.casacodigo.entity.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String nome);
}
