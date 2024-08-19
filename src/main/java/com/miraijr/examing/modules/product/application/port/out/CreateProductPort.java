package com.miraijr.examing.modules.product.application.port.out;

import com.miraijr.examing.modules.product.domain.Product;

public interface CreateProductPort {
  Product createProduct(Product product);
}
