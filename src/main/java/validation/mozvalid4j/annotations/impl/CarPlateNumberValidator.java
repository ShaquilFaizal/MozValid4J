package validation.mozvalid4j.annotations.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import validation.mozvalid4j.annotations.CarPlateNumber;
import validation.mozvalid4j.annotations.exceptionHandler.ValidationException;

public class CarPlateNumberValidator implements ConstraintValidator<CarPlateNumber, String> {

    private static final String CAR_PLATE_NUMBER_PATTERN = "^[A-Z]{3}-(\\d{3}-[A-Z]{2}|\\d{2}-\\d{2})$";
    private boolean isBiometricOnly;
    private String message;
    @Override
    public void initialize(CarPlateNumber carPlateNumber) {
        ConstraintValidator.super.initialize(carPlateNumber);
        this.isBiometricOnly=carPlateNumber.isBiometricOnly();
        this.message = carPlateNumber.message();
    }

    @Override
    public boolean isValid(String carPlateNumber, ConstraintValidatorContext constraintValidatorContext) {
        String patternToUse = isBiometricOnly ? "^[A-Z]{3}-\\d{3}-[A-Z]{2}$" : CAR_PLATE_NUMBER_PATTERN;
        boolean isValid = carPlateNumber.matches(patternToUse);
        if(!isValid) throw new ValidationException(message);
        return isValid;
    }
}
