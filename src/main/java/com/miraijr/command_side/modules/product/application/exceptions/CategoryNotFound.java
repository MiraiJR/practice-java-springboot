package com.miraijr.command_side.modules.product.application.exceptions;

import com.miraijr.command_side.core.application.ApplicationException;

public class CategoryNotFound extends ApplicationException {
  public CategoryNotFound() {
    super(ResourceError.CATEGORY_ERROR_0001.getCode(),
        ResourceError.CATEGORY_ERROR_0001.getMessage(),
        ResourceError.CATEGORY_ERROR_0001.getStatusCode());
  }
}
