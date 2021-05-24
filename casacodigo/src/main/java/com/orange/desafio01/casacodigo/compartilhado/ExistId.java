package com.orange.desafio01.casacodigo.compartilhado;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = { ExistIdValidator.class })
@Target({ FIELD })
@Retention(RUNTIME)
public @interface ExistId {

    String message() default "O atributo id nao existe no banco";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    Class<?> entidade();

}
