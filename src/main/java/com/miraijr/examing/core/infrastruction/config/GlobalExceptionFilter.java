package com.miraijr.examing.core.infrastruction.config;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import com.miraijr.examing.core.application.ApplicationException;
import com.miraijr.examing.core.domain.DomainException;
import com.miraijr.examing.shared.exceptions.ExceptionResponseModel;

@RestControllerAdvice
public class GlobalExceptionFilter {
  @ExceptionHandler({ ApplicationException.class })
  @ResponseBody
  public ResponseEntity<ExceptionResponseModel> handleApplicationException(ApplicationException exception) {
    return ResponseEntity.status(exception.getStatusCode())
        .body(new ExceptionResponseModel(
            exception.getErrorCode(),
            exception.getMessage(),
            exception.getCause() != null ? exception.getCause().getMessage() : exception.getMessage(),
            new Date(),
            exception.getStackTrace()));
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<ExceptionResponseModel> handleApplicationException(
      MethodArgumentTypeMismatchException exception) {
    String errorMessage = String.format("Invalid value '%s' for parameter '%s'. Expected type: %s",
        exception.getValue(),
        exception.getName(),
        exception.getRequiredType().getSimpleName());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new ExceptionResponseModel(
            exception.getErrorCode(),
            errorMessage,
            exception.getCause() != null ? exception.getCause().getMessage() : exception.getMessage(),
            new Date(),
            exception.getStackTrace()));
  }

  @ExceptionHandler({ DomainException.class })
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ResponseEntity<ExceptionResponseModel> handleDomainException(DomainException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new ExceptionResponseModel(
            exception.getErrorCode(),
            exception.getMessage(),
            exception.getCause() != null ? exception.getCause().getMessage() : exception.getMessage(),
            new Date(),
            exception.getStackTrace()));
  }

  @ExceptionHandler({ MethodArgumentNotValidException.class })
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ResponseEntity<ExceptionResponseModel> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseModel(
        "VALIDATEION-ERROR",
        exception.getBindingResult().getAllErrors().get(0).toString(),
        exception.getBindingResult().getAllErrors().get(0).toString(),
        new Date(),
        exception.getStackTrace()));
  }
}
