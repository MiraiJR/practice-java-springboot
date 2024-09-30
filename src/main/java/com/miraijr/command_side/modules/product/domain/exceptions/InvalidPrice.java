package com.miraijr.command_side.modules.product.domain.exceptions;

import com.miraijr.command_side.core.domain.DomainException;

public class InvalidPrice extends DomainException {
  public InvalidPrice() {
    super(ProductDomainError.DOMAIN_PRODUCT_ERROR_0001.getCode(),
        ProductDomainError.DOMAIN_PRODUCT_ERROR_0001.getMessage());
  }
}
