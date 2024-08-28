package com.miraijr.examing.modules.product.application.port.in.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetProductOutputModel {
    private Long id;
    private String name;
    private String description;
    private Float price;
    private Long stock;
    private String slug;
}
