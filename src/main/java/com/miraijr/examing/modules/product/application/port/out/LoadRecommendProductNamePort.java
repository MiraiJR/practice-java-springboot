package com.miraijr.examing.modules.product.application.port.out;

import java.util.List;

public interface LoadRecommendProductNamePort {
    List<String> loadRecommendProductName(String prompt) throws Exception;
}
