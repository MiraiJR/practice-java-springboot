package com.miraijr.examing.modules.product.application.port.out;

import com.miraijr.examing.modules.product.domain.Category;

public interface CreateCategoryPort {
  Category createCategory(Category category);
}
