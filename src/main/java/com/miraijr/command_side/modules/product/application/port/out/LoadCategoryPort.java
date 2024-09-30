package com.miraijr.command_side.modules.product.application.port.out;

import java.util.Optional;
import com.miraijr.command_side.modules.product.domain.Category;

public interface LoadCategoryPort {
  Optional<Category> loadCategory(Long id);
}
