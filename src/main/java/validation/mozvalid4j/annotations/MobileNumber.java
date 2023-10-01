package validation.mozvalid4j.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import validation.mozvalid4j.annotations.impl.MobileNumberValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MobileNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MobileNumber {
    String message() default "Número de telefone inválido";

    String countryCode() default "required";

    String[] allowedOperators() default {"tmcel","vodacom","movitel"};

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
