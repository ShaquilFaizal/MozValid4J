package validation.mozvalid4j.annotations.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import validation.mozvalid4j.annotations.NUIT;

public class NUITvalidator implements ConstraintValidator<NUIT, String> {
    @Override
    public boolean isValid(String nuit, ConstraintValidatorContext constraintValidatorContext) {
        return  nuit!=null && nuit.matches("^\\d{9}$");
    }
}
