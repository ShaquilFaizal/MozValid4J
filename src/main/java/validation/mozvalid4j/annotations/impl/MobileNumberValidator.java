package validation.mozvalid4j.annotations.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
//import jakarta.validation.ValidationException;
import validation.mozvalid4j.annotations.MobileNumber;
import validation.mozvalid4j.annotations.exceptionHandler.ValidationException;

public class MobileNumberValidator implements ConstraintValidator<MobileNumber, String> {
    private String countryCode;
    private  String message;
    private String[] allowedOperators;
    @Override
    public void initialize(MobileNumber mobileNumber) {
        ConstraintValidator.super.initialize(mobileNumber);
        this.countryCode = mobileNumber.countryCode();
        this.allowedOperators = mobileNumber.allowedOperators();
        this.message = mobileNumber.message();
    }

    @Override
    public boolean isValid(String mobileNumber, ConstraintValidatorContext context) {
        boolean isValid = switch (countryCode.toLowerCase()) {
            case "required" -> validateMobileNumberWithCountryCode(mobileNumber, allowedOperators);
            case "off" -> validateMobileNumberWithoutCountryCode(mobileNumber, allowedOperators);
            case "optional" ->
                    checkIfNumberHasCountryCode(mobileNumber) ? validateMobileNumberWithCountryCode(mobileNumber, allowedOperators) : validateMobileNumberWithoutCountryCode(mobileNumber, allowedOperators);
            default -> false;
        };
        if(!isValid){
            throw new ValidationException(message);
        }
       return isValid;
    }

   private boolean checkIfNumberHasCountryCode(String mobileNumber){
        return mobileNumber.matches("^\\+?258.*");
   }
    private boolean validateMobileNumberWithCountryCode(String mobileNumber,String[] allowedOperators) {
        if(checkIfNumberHasCountryCode(mobileNumber)){
            String numberWithoutCountryCode = mobileNumber.replaceFirst("^\\+?258", "");
            return validateMobileNumberWithoutCountryCode(numberWithoutCountryCode,allowedOperators);
        }
        return false;
    }
    private boolean validateMobileNumberWithoutCountryCode(String mobileNumber,String[] allowedOperators) {
        String regex = getMobileNumberRegexWithoutCountryCode(allowedOperators);
        return mobileNumber.matches(regex);
    }
    private String getMobileNumberRegexWithoutCountryCode(String [] allowedOperators) {
        StringBuilder regexBuilder = new StringBuilder("^(");
        for(String operator: allowedOperators){
            switch (operator.toLowerCase()){
                case "tmcel":
                    regexBuilder.append("82\\d{7}|83\\d{7}|");
                    break;
                case "vodacom":
                    regexBuilder.append("84\\d{7}|85\\d{7}|");
                    break;
                case "movitel":
                    regexBuilder.append("86\\d{7}|87\\d{7}|");
                    break;
            }
        }
        if (regexBuilder.charAt(regexBuilder.length() - 1) == '|') {
            regexBuilder.deleteCharAt(regexBuilder.length() - 1);
        }

        regexBuilder.append(")$");

        return regexBuilder.toString();
    }

}
