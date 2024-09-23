package com.miraijr.examing.modules.product.application.port.in.output;

import com.miraijr.examing.modules.product.domain.Product;
import lombok.Builder;

@Builder
public record RecommendProductOutputModel(Long id,
    String name,
    String slug,
    String description,
    Float price,
    Long categoryId) {

  public static RecommendProductOutputModel convertFromDomainEntity(Product product) {
    return RecommendProductOutputModel.builder()
        .id(product.getId())
        .name(product.getName())
        .slug(product.getSlug())
        .description(product.getDescription())
        .price(product.getPrice().getValue())
        .categoryId(product.getCategory().getId())
        .build();
  }
}
