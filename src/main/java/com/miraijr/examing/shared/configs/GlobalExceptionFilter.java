package com.miraijr.examing.shared.configs;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miraijr.examing.shared.exceptions.ApplicationException;
import com.miraijr.examing.shared.exceptions.ErrorResponseEntity;

@ControllerAdvice
public class GlobalExceptionFilter {
  @ExceptionHandler(ApplicationException.class)
  @ResponseBody
  public ResponseEntity<ErrorResponseEntity> handleResourceNotFoundException(ApplicationException exception) {
    return ResponseEntity.status(exception.getStatusCode())
        .body(new ErrorResponseEntity(
            exception.getErrorCode(),
            exception.getMessage(),
            exception.getCause() != null ? exception.getCause().getMessage() : exception.getMessage(),
            exception.getStackTrace()));
  }
}
