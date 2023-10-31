# MozValid4J 🇲🇿 [![My Skills](https://skillicons.dev/icons?i=java)](https://skillicons.dev)

#### This project is a Java validation library made for Mozambique.
## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
    - [Mobile Number](#mobile-number)
      - [Options](#options)
      - [Example](#examples)
    - [NUIT](#nuit)
    - [IBAN](#iban)
    - [Identity Number](#identity-number)
    - [Car Plate Number](#car-plate-number)
      - [Options](#options-car-plate-number)
      - [Example](#examples-car-plate-number)



## Installation
To use MozValid4J in your Java project, include the following Maven dependency:

```xml
<dependency>
    <groupId></groupId>
    <artifactId></artifactId>
    <version></version>
</dependency>
```

# `Usage`
MozValid4J offers a set of annotations to validate various Mozambican data types in your Java classes.

## `Mobile Number`
#### Check if a string is a valid mozambican mobile number.

### Options

| Option           | Type     | Accepted Value(s)                               | Description                                                                                                                                                                                                                                                                                  |
|------------------|----------|-------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| allowedOperators | string[] | <br><br> `vodacom`, `tmcel`, `movitel` <br><br> |List of mobile network operators to limit the validation on. If passed an emtpy array, it will validate for all network operators.                                                                                                                                                            |
| countryCode      | string   | `optional`, `required`,`off`                    |<br> `optional`: the country code in the number being validated is optional. <br> `required` : only return true if the number includes the country code. <br>`off` : only return true if the number does not include the country code. <br><br> The country code can be in either `+258` or `258` format. <br><br>|        
| message          | string   |                                                 |                              A custom error message. If not provided, the default error message will be used.                                                                                                                                                                                                                                                                                    |
### Examples

```java
import lombok.Getter;
import lombok.Setter;
import validation.mozvalid4j.annotations.MobileNumber;

@Getter
@Setter
public class UserRequest {

    @MobileNumber
    private String mobileNumber;

    @MobileNumber(allowedOperators = {"vodacom","movitel"},
            countryCode = "optional",
            message = "Custom error message for alternative mobile number")   
    private String alternativeMobileNumber;
}

```
## `NUIT`
#### Check if a string is a valid Mozambican NUIT (Número Único de Identificação Tributária). You can specify options such as a custom error message. If a custom message is not provided, a default message will be used.

```java
import lombok.Getter;
import lombok.Setter;
import validation.mozvalid4j.annotations.NUIT;

@Getter
@Setter
public class UserRequest {

    @NUIT
    private String nuitNumber;
    
    @NUIT(message = "Custom error message for NUIT")
    private String customNuitNumber;
}
```
## `IBAN`
#### Check if a string is a valid Mozambican formatted International Bank Account Number (IBAN) according to ISO 13616. You can specify options such as a custom error message. If a custom message is not provided, a default message will be used.
### Example
```java
import lombok.Getter;
import lombok.Setter;
import validation.mozvalid4j.annotations.IBAN;

@Getter
@Setter
public class UserRequest {

    @IBAN
    private String iban;
    
    @IBAN(message = "Custom error message for IBAN")
    private String customIban;
}
```
## `BI - Identity Number`
#### Check if a string is a valid Mozambican Identity Number.
### Example
```java
import lombok.Getter;
import lombok.Setter;
import validation.mozvalid4j.annotations.IdentityNumber;

@Getter
@Setter
public class UserRequest {

    @IdentityNumber
    private String identityNumber;
    
    @IdentityNumber(message = "Custom error message for Identity Number")
    private String customIdentityNumber;
}
```
## `Car Plate Number`
#### Check if a string is a valid Mozambican car plate number.

### Options

| Option          | Type    | Accepted Value(s)                   | Description                                                                                                                                                                                                                                                                                  |
|-----------------|---------|-------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| isBiometricOnly | boolean | `true`, `false`|If set to true, the validation will check if the car plate number is for biometric use only.                                                                                                                                    |
| message         | string  |                                     |                              A custom error message. If not provided, the default error message will be used.                                                                                                                                                                                                                                                                                    |
### Example
```java
import lombok.Getter;
import lombok.Setter;
import validation.mozvalid4j.annotations.CarPlateNumber;

@Getter
@Setter
public class UserRequest {

    @CarPlateNumber
    private String carPlateNumber;

    @CarPlateNumber(isBiometricOnly = true,
            message = "Custom error message for car plate")
    private String carPlateNumber;
}
```

## Contributing

We welcome contributions from the community. If you'd like to contribute to MozValid4J, please follow these guidelines:
- Fork the repository.
- Create a new branch for your feature or bug fix.
- Make your changes and submit a pull request.


## License

MozValid4J is open-source software licensed under the [MIT License](LICENSE). You are free to use, modify, and distribute this software as long as you include the original copyright notice.

Feel free to adapt the contributing guidelines and license information to suit your project's specific needs. This addition helps make your project more welcoming to contributors and clarifies how others can use your code.

