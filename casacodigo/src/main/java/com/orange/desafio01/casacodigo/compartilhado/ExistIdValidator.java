package com.orange.desafio01.casacodigo.compartilhado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistIdValidator implements ConstraintValidator<ExistId, Long>{

    private Class<?> entidade;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void initialize(ExistId constraintAnnotation) {
        this.entidade = constraintAnnotation.entidade();
    }

    public boolean isValid(Long valor, ConstraintValidatorContext context) {

        Query query = em.createQuery("select 1 from " + entidade.getName() +
                                                    " where id = :valor" );
        query.setParameter("valor", valor);

        List<?> resultado = query.getResultList();

        return !resultado.isEmpty();
    }

}
