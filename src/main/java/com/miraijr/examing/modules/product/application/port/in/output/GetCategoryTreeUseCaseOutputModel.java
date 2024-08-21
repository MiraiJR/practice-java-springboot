package com.miraijr.examing.modules.product.application.port.in.output;

import java.util.ArrayList;
import java.util.List;

import com.miraijr.examing.modules.product.domain.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCategoryTreeUseCaseOutputModel {
  private Long id;
  private List<GetCategoryTreeUseCaseOutputModel> childrens;
  private String name;
  private String slug;

  public static GetCategoryTreeUseCaseOutputModel convertFromDomainEntity(Category category) {
    var builder = GetCategoryTreeUseCaseOutputModel.builder();
    builder.id(category.getId()).name(category.getName()).slug(category.getSlug());

    if (category.getChildrens() != null) {
      builder.childrens(
          category.getChildrens().stream().map(GetCategoryTreeUseCaseOutputModel::convertFromDomainEntity).toList());
    } else {
      builder.childrens(new ArrayList<>());
    }

    return builder.build();
  }
}
