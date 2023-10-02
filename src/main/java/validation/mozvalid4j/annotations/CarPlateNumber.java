package validation.mozvalid4j.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import validation.mozvalid4j.annotations.impl.CarPlateNumberValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CarPlateNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CarPlateNumber {
    String message() default "Número de chapa de matrícula inválido";

    boolean isBiometricOnly() default false;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
