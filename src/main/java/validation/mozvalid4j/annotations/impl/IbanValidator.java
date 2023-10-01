package validation.mozvalid4j.annotations.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import validation.mozvalid4j.annotations.IBAN;

public class IbanValidator implements ConstraintValidator<IBAN,String> {
    @Override
    public boolean isValid(String iban, ConstraintValidatorContext constraintValidatorContext) {
        return iban.matches("^MZ59\\d{21}$");
    }
}
