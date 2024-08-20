package com.miraijr.examing.modules.product.application.port.out;

import java.util.Optional;

import com.miraijr.examing.modules.product.domain.Category;

public interface LoadCategoryPort {
  Optional<Category> loadCategory(Long id);
}
