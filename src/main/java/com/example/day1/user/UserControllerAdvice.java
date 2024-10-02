package com.example.day1.user;

import com.example.day1.global.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

@RestControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(UserNotFouneException.class)
    public ResponseEntity<ErrorResponse> userNotFoundt(UserNotFouneException userNotFouneException){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("User Not Found");
        ResponseEntity<ErrorResponse> responseEntity  = new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> methodArgumentTypeMismatchException(Exception exception){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        ResponseEntity<ErrorResponse> responseEntity  = new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

}
