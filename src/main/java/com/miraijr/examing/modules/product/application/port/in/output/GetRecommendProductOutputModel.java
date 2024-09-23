package com.miraijr.examing.modules.product.application.port.in.output;

import java.util.List;

import lombok.Builder;

@Builder
public record GetRecommendProductOutputModel(String query, List<RecommendProductOutputModel> result) {
}
