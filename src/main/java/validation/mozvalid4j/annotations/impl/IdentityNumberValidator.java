package validation.mozvalid4j.annotations.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import validation.mozvalid4j.annotations.IdentityNumber;

public class IdentityNumberValidator implements ConstraintValidator<IdentityNumber,String> {
    @Override
    public boolean isValid(String identityNumber, ConstraintValidatorContext constraintValidatorContext) {
        return identityNumber!=null && identityNumber.matches("([0-9]{12})[a-zA-Z]$");
    }
}
