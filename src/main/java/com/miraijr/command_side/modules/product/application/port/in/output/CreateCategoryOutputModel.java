package com.miraijr.command_side.modules.product.application.port.in.output;

import java.util.Date;
import com.miraijr.command_side.modules.product.domain.Category;
import lombok.Builder;

@Builder
public record CreateCategoryOutputModel(
    Long id,
    Long parentId,
    String name,
    String slug,
    Date createdAt,
    Date updatedAt) {
  public static CreateCategoryOutputModel convertFromDomain(Category category) {
    var builder = CreateCategoryOutputModel.builder();
    builder.id(category.getId())
        .name(category.getName())
        .slug(category.getSlug())
        .createdAt(category.getCreatedAt())
        .updatedAt(category.getUpdatedAt());

    if (category.getParent() != null) {
      builder.parentId(category.getParent().getId());
    }

    return builder.build();
  }
}
