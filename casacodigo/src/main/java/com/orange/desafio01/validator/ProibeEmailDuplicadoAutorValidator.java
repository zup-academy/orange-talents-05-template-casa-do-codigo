package com.orange.desafio01.validator;

import java.util.Optional;

import com.orange.desafio01.casacodigo.dto.AutorRequest;
import com.orange.desafio01.casacodigo.entity.Autor;
import com.orange.desafio01.repository.AutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator{

    @Autowired
    private AutorRepository autorRepository;
    
    @Override
    public boolean supports(Class<?> clazz) {
        return AutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){
        if(errors.hasErrors()) {
            return;
        }
        AutorRequest autorRequest = (AutorRequest) target;
        Optional<Autor> emailValiation = autorRepository.findByEmail(autorRequest.getEmail());
        
        if (emailValiation.isPresent()) {
            errors.rejectValue("email", null, "O email não pode ser duplicado "
                + autorRequest.getEmail());
        }
    }
}
