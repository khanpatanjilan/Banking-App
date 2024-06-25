package net.javaguides.banking.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    //handling specific exception

    @ExceptionHandler(AccountException.class)
    public ResponseEntity<ErrorDeatils> handleAccountException(AccountException Exception,
                                                               WebRequest webRequest){

        ErrorDeatils errorDeatils = new ErrorDeatils(
                LocalDateTime.now(),
                Exception.getMessage(),
                webRequest.getDescription(false),
                "Account_Not_Found"

        );
                return new ResponseEntity<>(errorDeatils, HttpStatus.NOT_FOUND);
    }

    //handling GolbalException

    public ResponseEntity<ErrorDeatils> handleGolbalException(Exception exception,
                                                              WebRequest webRequest){
        ErrorDeatils errorDeatils = new ErrorDeatils(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "Internal_Server_Error"
        );
        return  new ResponseEntity<>(errorDeatils,HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
