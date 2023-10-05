package validation.mozvalid4j.annotations.exceptionHandler;

public class ValidationException extends RuntimeException{

    public ValidationException(String message){
        super(message);
    }
}
