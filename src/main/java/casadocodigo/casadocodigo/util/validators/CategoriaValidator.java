package casadocodigo.casadocodigo.util.validators;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CategoriaValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return CategoriaDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "nomeCategoria", "O nome da categoia não pode serr nulo!");
    }
}
