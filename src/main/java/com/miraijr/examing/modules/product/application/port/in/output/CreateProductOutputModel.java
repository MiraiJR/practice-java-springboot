package com.miraijr.examing.modules.product.application.port.in.output;

import com.miraijr.examing.modules.product.domain.Product;

import lombok.Builder;

@Builder
public record CreateProductOutputModel(
    Long id,
    String name,
    String description,
    Float price,
    Long stock,
    String slug,
    Long categoryId) {

  public static CreateProductOutputModel convertFromDomainEntity(Product product) {
    return CreateProductOutputModel.builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .price(product.getPrice().getValue())
        .stock(product.getStock())
        .slug(product.getSlug())
        .categoryId(product.getCategory().getId())
        .build();
  }
}
