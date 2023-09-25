package validation.mozvalid4j.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import validation.mozvalid4j.annotations.impl.IdentityNumberValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IdentityNumberValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IdentityNumber {
    String message() default "Número de bilhete de identidade inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
