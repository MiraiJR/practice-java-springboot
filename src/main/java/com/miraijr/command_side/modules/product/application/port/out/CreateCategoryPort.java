package com.miraijr.command_side.modules.product.application.port.out;

import com.miraijr.command_side.modules.product.domain.Category;

public interface CreateCategoryPort {
  Category createCategory(Category category);
}
