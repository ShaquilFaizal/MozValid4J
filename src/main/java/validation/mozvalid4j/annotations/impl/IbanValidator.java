package validation.mozvalid4j.annotations.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import validation.mozvalid4j.annotations.IBAN;
import validation.mozvalid4j.annotations.exceptionHandler.ValidationException;

public class IbanValidator implements ConstraintValidator<IBAN,String> {
    private String message;

    @Override
    public void initialize(IBAN iban) {
        ConstraintValidator.super.initialize(iban);
        this.message=iban.message();
    }

    @Override
    public boolean isValid(String iban, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid =iban.matches("^MZ59\\d{21}$");

        if(!isValid){
            throw new ValidationException(message);
        }
        return isValid;
    }
}
