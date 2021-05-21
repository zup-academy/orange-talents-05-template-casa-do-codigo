package casadocodigo.casadocodigo.util.validators;

import casadocodigo.casadocodigo.util.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD}) //Será validada uma coluna do objeto e não ele todo
@Retention(RetentionPolicy.RUNTIME) // Será validado em tempo de execução
@Constraint(validatedBy = EmailValidator.class) //Qual classe que será validada
@Documented
public @interface Email {

    String message() default "E-mail inválido!"; //Mensagem que será exibida caso o e-mail não seja válido
    Class<?>[] groups() default {}; // Grupo de classes que será utilizado a validação
    Class<? extends Payload>[] payload() default {}; //Qualquer classe que forr anotada com payload será validada com esse método
}
