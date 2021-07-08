package com.orange.desafio01.casacodigo.compartilhado;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = { UniqueValueToUniqueIdValidator.class })
@Target({ FIELD, TYPE })
@Retention(RUNTIME)
public @interface UniqueValueToUniqueId {
    String message() default "{javax.validation.constraints.UniqueValueToUniqueId.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
