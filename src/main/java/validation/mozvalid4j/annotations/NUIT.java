package validation.mozvalid4j.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import validation.mozvalid4j.annotations.impl.NUITvalidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NUITvalidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NUIT {
    String message() default "Número de NUIT inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
