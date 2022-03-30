package com.app.exception;


import com.app.dto.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, String> collect = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, e-> Optional.ofNullable(e.getDefaultMessage()).orElse("can't be null"),(e1, e2) -> e1 + "," + e2));

        return ResponseEntity.badRequest().body(new ApiResponse<>(HttpStatus.BAD_REQUEST,"Failure",collect));
//        return new ResponseEntity<>(collect,headers,status);
    }

    @ExceptionHandler(value={ConstraintViolationException.class})
    public ResponseEntity<ApiResponse<?>> handleConstraintViolationException(ConstraintViolationException ex){
//        Map<String, String> collect = ex.getConstraintViolations().stream().collect(Collectors.toMap(e -> e.getPropertyPath().toString(), ConstraintViolation::getMessage));
        List<String> collect = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.BAD_REQUEST,"Failure",collect),HttpStatus.BAD_REQUEST);
    }


}
