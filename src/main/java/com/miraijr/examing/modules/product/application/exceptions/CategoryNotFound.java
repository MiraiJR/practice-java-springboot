package com.miraijr.examing.modules.product.application.exceptions;

import com.miraijr.examing.core.application.ApplicationException;

public class CategoryNotFound extends ApplicationException {
  public CategoryNotFound() {
    super(ResourceError.CATEGORY_ERROR_0001.getCode(),
        ResourceError.CATEGORY_ERROR_0001.getMessage(),
        ResourceError.CATEGORY_ERROR_0001.getStatusCode());
  }
}
