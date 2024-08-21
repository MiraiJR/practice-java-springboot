package com.miraijr.examing.modules.product.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.miraijr.examing.modules.product.application.port.in.GetCategoryTreeUseCase;
import com.miraijr.examing.modules.product.application.port.in.output.GetCategoryTreeUseCaseOutputModel;
import com.miraijr.examing.modules.product.application.port.out.LoadCategoryPort;
import com.miraijr.examing.modules.product.domain.Category;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetCategoryTreeService implements GetCategoryTreeUseCase {
  private final LoadCategoryPort loadCategoryPort;

  @Override
  public List<GetCategoryTreeUseCaseOutputModel> getCategoriesTreeView() {
    List<Category> categories = this.loadCategoryPort.loadCategories();

    return this.buildCategoryTree(categories).stream()
        .map(GetCategoryTreeUseCaseOutputModel::convertFromDomainEntity)
        .toList();
  }

  private List<Category> buildCategoryTree(List<Category> categories) {
    Map<Long, Category> categoryMap = new HashMap<>();
    List<Category> rootCategories = new ArrayList<>();

    for (Category category : categories) {
      categoryMap.put(category.getId(), category);
    }

    for (Category category : categories) {
      if (category.getParent() == null) {
        rootCategories.add(category);
        continue;
      }

      Category parentCategory = categoryMap.get(category.getParent().getId());
      if (parentCategory != null) {
        parentCategory.addChildren(category);
      }
    }

    return rootCategories;
  }
}
