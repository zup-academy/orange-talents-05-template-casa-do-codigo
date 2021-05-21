package com.orange.desafio01.validator;

import java.util.Optional;

import com.orange.desafio01.casacodigo.dto.CategoriaRequest;
import com.orange.desafio01.casacodigo.entity.Categoria;
import com.orange.desafio01.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){
        if(errors.hasErrors()) {
            return;
        }

        CategoriaRequest categoriaRequest = (CategoriaRequest) target;
        Optional<Categoria> nomeValidation = categoriaRepository.findByNome(categoriaRequest.getNome());
        
        if (nomeValidation.isPresent()) {
            errors.rejectValue("nome", null, "O nome não pode ser duplicado "
                + categoriaRequest.getNome());
        }

    }
}
