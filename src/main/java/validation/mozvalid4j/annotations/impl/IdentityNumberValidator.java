package validation.mozvalid4j.annotations.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import validation.mozvalid4j.annotations.IdentityNumber;
import validation.mozvalid4j.annotations.exceptionHandler.ValidationException;

public class IdentityNumberValidator implements ConstraintValidator<IdentityNumber,String> {
    private String message;

    @Override
    public void initialize(IdentityNumber identityNumber) {
        ConstraintValidator.super.initialize(identityNumber);
        this.message = identityNumber.message();
    }

    @Override
    public boolean isValid(String identityNumber, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = identityNumber!=null && identityNumber.matches("([0-9]{12})[a-zA-Z]$");

        if(!isValid){
            throw new ValidationException(message);
        }
        return isValid;
    }
}
