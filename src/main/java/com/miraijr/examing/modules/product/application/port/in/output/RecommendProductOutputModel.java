package com.miraijr.examing.modules.product.application.port.in.output;

import com.miraijr.examing.modules.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecommendProductOutputModel {
    private Long id;
    private String name;
    private String slug;
    private String description;
    private Float price;
    private Long categoryId;

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
