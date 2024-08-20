package com.miraijr.examing.modules.product.application.exceptions;

import com.miraijr.examing.core.application.ApplicationException;

public class CategoryNotFound extends ApplicationException {
  public CategoryNotFound() {
    super(CategoryError.CATEGORY_ERROR_0001.getCode(),
        CategoryError.CATEGORY_ERROR_0001.getMessage(),
        CategoryError.CATEGORY_ERROR_0001.getStatusCode());
  }
}
