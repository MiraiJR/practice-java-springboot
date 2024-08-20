package com.miraijr.examing.modules.product.application.port.in.output;

import com.miraijr.examing.modules.product.domain.Product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateProductOutputModel {
  private Long id;
  private String name;
  private String description;
  private Float price;
  private Long stock;
  private String slug;
  private Long categoryId;

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
