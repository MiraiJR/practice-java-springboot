package com.miraijr.examing.modules.product.application.port.in.output;

import lombok.Builder;

@Builder
public record GetProductOutputModel(
    Long id,
    String name,
    String description,
    Float price,
    Long stock,
    String slug) {
}
