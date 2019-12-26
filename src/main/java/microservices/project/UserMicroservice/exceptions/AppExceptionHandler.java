package microservices.project.UserMicroservice.exceptions;

import microservices.project.UserMicroservice.models.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex , WebRequest request){
        ErrorMessage exception = new ErrorMessage(new Date(), ex.getLocalizedMessage());
        return new ResponseEntity<>(
                exception , new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
    public ResponseEntity<Object> handleSpesificException(Exception ex , WebRequest request){
        ErrorMessage exception = new ErrorMessage(new Date(), ex.getLocalizedMessage());
        return new ResponseEntity<>(
                exception , new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
