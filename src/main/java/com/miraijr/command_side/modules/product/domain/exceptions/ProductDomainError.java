package com.miraijr.command_side.modules.product.domain.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductDomainError {
  DOMAIN_PRODUCT_ERROR_0001("DOMAIN-PRODUCT-ERROR-0001", "Invalid price");

  private final String code;
  private final String message;
}
