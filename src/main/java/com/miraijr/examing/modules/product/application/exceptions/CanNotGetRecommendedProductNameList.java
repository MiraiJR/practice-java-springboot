package com.miraijr.examing.modules.product.application.exceptions;

import com.miraijr.examing.core.application.ApplicationException;

public class CanNotGetRecommendedProductNameList extends ApplicationException {
  public CanNotGetRecommendedProductNameList() {
    super(ResourceError.PRODUCT_ERROR_0001.getCode(),
        ResourceError.PRODUCT_ERROR_0001.getMessage(),
        ResourceError.PRODUCT_ERROR_0001.getStatusCode());
  }
}
