package com.orange.desafio01.repository;

import java.util.Optional;

import com.orange.desafio01.casacodigo.entity.Autor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByEmail(String email);

}
