package com.orange.desafio01.casacodigo.compartilhado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.orange.desafio01.casacodigo.dto.EstadoRequest;


public class UniqueValueToUniqueIdValidator implements ConstraintValidator<UniqueValueToUniqueId, EstadoRequest> {

    @PersistenceContext
    private EntityManager em;

    public boolean isValid(EstadoRequest estadoRequest, ConstraintValidatorContext context) {
        String nome = estadoRequest.getNome();
        Long id = estadoRequest.getPais_id();
        System.out.println(nome);
        System.out.println(id);

        Query query = em.createQuery("select 1 from Estado s where s.nome = :nome AND s.pais.id = :id");
        // select 1 from State s where s.name = :name and s.country.id = :id
        // SELECT p FROM Estado e, Pais p WHERE p.id = :idPais AND e.pais = p

        query.setParameter("nome", nome);
        query.setParameter("id", id);

        List<?> resultado = query.getResultList();
        System.out.println(resultado.isEmpty());
        return resultado.isEmpty();
    }

}
