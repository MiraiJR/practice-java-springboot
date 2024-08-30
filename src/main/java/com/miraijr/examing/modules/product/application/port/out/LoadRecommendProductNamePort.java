package com.miraijr.examing.modules.product.application.port.out;

import java.util.List;

import com.miraijr.examing.modules.product.domain.Product;

public interface LoadRecommendProductNamePort {
    List<Product> loadRecommendProductName(String prompt) throws Exception;

    List<Product> loadRecommendProductName(String prompt, Float minPrice, Float maxPrice) throws Exception;
}
