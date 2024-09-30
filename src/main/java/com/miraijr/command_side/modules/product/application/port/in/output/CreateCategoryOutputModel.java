package com.miraijr.command_side.modules.product.application.port.in.output;

import com.miraijr.command_side.modules.product.domain.Category;

import lombok.Builder;

@Builder
public record CreateCategoryOutputModel(Long id, Long parentId, String name, String slug) {
  public static CreateCategoryOutputModel convertFromDomain(Category category) {
    var builder = CreateCategoryOutputModel.builder();
    builder.id(category.getId()).name(category.getName()).slug(category.getSlug());

    if (category.getParent() != null) {
      builder.parentId(category.getParent().getId());
    }

    return builder.build();
  }
}
