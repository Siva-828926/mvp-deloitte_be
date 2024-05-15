package com.mvp.mvp.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mvp.mvp.pojo.response.MVPExceptionResponse;

@ControllerAdvice
public class MVPException {

    @ExceptionHandler
    public ResponseEntity<MVPExceptionResponse> exceptionHandler(Exception exception) {

        if (exception instanceof MethodArgumentNotValidException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(buildExceptionResponse(listOfValidationException(exception)));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    private MVPExceptionResponse buildExceptionResponse(List<String> message) {
        return MVPExceptionResponse.builder().exceptionMessage(message).build();
    }

    private List<String> listOfValidationException(Exception exception) {
        return ((BindException) exception).getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
    }
}
