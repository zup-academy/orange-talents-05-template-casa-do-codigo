package casadocodigo.casadocodigo.util;

import casadocodigo.casadocodigo.dtos.AutorDTO;
import casadocodigo.casadocodigo.dtos.EmailDTO;
import casadocodigo.casadocodigo.gateway.repositories.AutorRepository;
import casadocodigo.casadocodigo.util.validators.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class EmailValidator implements ConstraintValidator<Email, String> {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (verificaArroba(s)){
            if (emailDuplicado(s)){
                return false;
            } else return true;
        }
        return false;
    }

    private boolean verificaArroba(String email){

        return email.contains("@");
    } //Função que verifica se o e-mail tem @



    private boolean emailDuplicado(String email) {

        var opcionalAutor = autorRepository.findById(email);

        return opcionalAutor.isPresent();
    }


}
