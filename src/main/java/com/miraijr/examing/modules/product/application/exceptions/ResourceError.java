package com.miraijr.examing.modules.product.application.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResourceError {
  // Category error
  CATEGORY_ERROR_0001("CATEGORY-ERROR-0001", "Category not found", HttpStatus.NOT_FOUND),

  // Product error
  PRODUCT_ERROR_0001("PRODUCT-ERROR-0001", "Can not get recommended product list name", HttpStatus.BAD_REQUEST);

  private final String code;
  private final String message;
  private final HttpStatus statusCode;
}
