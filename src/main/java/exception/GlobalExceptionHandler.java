package exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleAllExceptions(Exception ex) {
        return ex.getMessage(); // or return a custom error response
    }



    //response for validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp){
        //filed and value
        var errors = new HashMap<String,String>();
        exp.getBindingResult().getAllErrors() //return list of errors
                .forEach(error->{
                            var filedName = ((FieldError)error).getField();
                            var errorMessage = error.getDefaultMessage();
                            errors.put(filedName,errorMessage);
                        }
                );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
