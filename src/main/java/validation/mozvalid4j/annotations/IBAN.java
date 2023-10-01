package validation.mozvalid4j.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import validation.mozvalid4j.annotations.impl.IbanValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IbanValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IBAN {
    String message() default "Número de IBAN inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
