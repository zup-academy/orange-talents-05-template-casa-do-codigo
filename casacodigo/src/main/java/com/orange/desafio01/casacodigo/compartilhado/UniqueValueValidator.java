package com.orange.desafio01.casacodigo.compartilhado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String> {

    private Class<?> entidade;
    private String fieldName;
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void initialize(UniqueValue constraintAnnotation) { // nome da anotaçao 
        this.entidade = constraintAnnotation.entidade(); // campos declarados na entidade
        this.fieldName = constraintAnnotation.fieldName();
    }

    public boolean isValid(String valor, ConstraintValidatorContext context) {

        Query query = em.createQuery("select 1 from " + entidade.getName() +
                                                    " where " + fieldName + " = :valor" );
        query.setParameter("valor", valor);

        List<?> resultado = query.getResultList();

        return resultado.isEmpty();
    }

}
