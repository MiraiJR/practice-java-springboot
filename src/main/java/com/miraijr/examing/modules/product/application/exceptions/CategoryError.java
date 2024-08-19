package com.miraijr.examing.modules.product.application.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryError {
  CATEGORY_ERROR_0001("CATEGORY-ERROR-0001", "Category not found", HttpStatus.NOT_FOUND);

  private final String code;
  private final String message;
  private final HttpStatus statusCode;
}
