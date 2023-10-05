package validation.mozvalid4j.annotations.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import validation.mozvalid4j.annotations.NUIT;
import validation.mozvalid4j.annotations.exceptionHandler.ValidationException;

public class NUITvalidator implements ConstraintValidator<NUIT, String> {

    private String message;

    @Override
    public void initialize(NUIT nuit) {
        ConstraintValidator.super.initialize(nuit);
        this.message = nuit.message();
    }

    @Override
    public boolean isValid(String nuit, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = nuit!=null && nuit.matches("^\\d{9}$");
        if(!isValid){
            throw new ValidationException(message);
        }
        return  isValid;
    }
}
