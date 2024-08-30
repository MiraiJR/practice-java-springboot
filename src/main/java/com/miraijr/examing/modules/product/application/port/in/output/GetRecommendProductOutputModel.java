package com.miraijr.examing.modules.product.application.port.in.output;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetRecommendProductOutputModel {
    private String query;
    private List<RecommendProductOutputModel> result;
}
