package com.miraijr.command_side.modules.product.application.exceptions;

import com.miraijr.command_side.core.application.ApplicationException;

public class CanNotGetRecommendedProductNameList extends ApplicationException {
  public CanNotGetRecommendedProductNameList() {
    super(ResourceError.PRODUCT_ERROR_0001.getCode(),
        ResourceError.PRODUCT_ERROR_0001.getMessage(),
        ResourceError.PRODUCT_ERROR_0001.getStatusCode());
  }
}
