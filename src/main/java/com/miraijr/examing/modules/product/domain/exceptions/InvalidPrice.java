package com.miraijr.examing.modules.product.domain.exceptions;

import com.miraijr.examing.core.domain.DomainException;

public class InvalidPrice extends DomainException {
  public InvalidPrice() {
    super(ProductDomainError.DOMAIN_PRODUCT_ERROR_0001.getCode(),
        ProductDomainError.DOMAIN_PRODUCT_ERROR_0001.getMessage());
  }
}
