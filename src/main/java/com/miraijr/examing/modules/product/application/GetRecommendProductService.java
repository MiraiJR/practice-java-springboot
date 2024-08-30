package com.miraijr.examing.modules.product.application;

import java.util.List;
import org.springframework.stereotype.Component;
import com.miraijr.examing.modules.product.application.exceptions.CanNotGetRecommendedProductNameList;
import com.miraijr.examing.modules.product.application.port.in.GetRecommendProductUseCase;
import com.miraijr.examing.modules.product.application.port.in.input.GetRecommendProductInputModel;
import com.miraijr.examing.modules.product.application.port.in.output.GetRecommendProductOutputModel;
import com.miraijr.examing.modules.product.application.port.in.output.RecommendProductOutputModel;
import com.miraijr.examing.modules.product.application.port.out.LoadRecommendProductNamePort;
import com.miraijr.examing.modules.product.domain.Product;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetRecommendProductService implements GetRecommendProductUseCase {
    private final LoadRecommendProductNamePort loadRecommendProductNamePort;

    @Override
    public GetRecommendProductOutputModel getRecommendProduct(GetRecommendProductInputModel inputModel) {
        List<Product> recommendProductNameList;
        try {
            Boolean isFilterPrice = !(inputModel.getMaxPrice() == null || inputModel.getMinPrice() == null);

            if (isFilterPrice) {
                recommendProductNameList = this.loadRecommendProductNamePort.loadRecommendProductName(
                        inputModel.getPrompt(), inputModel.getMinPrice(), inputModel.getMaxPrice());
            } else {
                recommendProductNameList = this.loadRecommendProductNamePort
                        .loadRecommendProductName(inputModel.getPrompt());
            }

            return GetRecommendProductOutputModel
                    .builder()
                    .query(inputModel.getPrompt())
                    .result(recommendProductNameList.stream().map(RecommendProductOutputModel::convertFromDomainEntity)
                            .toList())
                    .build();
        } catch (Exception e) {
            throw new CanNotGetRecommendedProductNameList();
        }
    }
}
