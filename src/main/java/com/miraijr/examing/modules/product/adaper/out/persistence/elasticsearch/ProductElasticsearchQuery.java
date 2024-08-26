package com.miraijr.examing.modules.product.adaper.out.persistence.elasticsearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;
import com.miraijr.examing.modules.product.application.port.out.LoadRecommendProductNamePort;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductElasticsearchQuery implements LoadRecommendProductNamePort {
    private final ElasticsearchClient elasticsearchClient;
    private static final String INDEX = "products";
    private static final List<String> SEARCH_FIELDS = Arrays.asList("name", "description", "categoryName");

    @Override
    public List<String> loadRecommendProductName(String prompt) throws Exception {
        List<ProductEntityElasticsearch> recommendedProducts = new ArrayList<>();
        SearchResponse<ProductEntityElasticsearch> search;
        try {
            search = this.elasticsearchClient.search(s -> s
                    .index(INDEX)
                    .query(q -> q
                            .multiMatch(t -> t
                                    .query(prompt)
                                    .fields(SEARCH_FIELDS)
                                    .fuzziness("AUTO"))),
                    ProductEntityElasticsearch.class);
            search.hits().hits().forEach(hit -> recommendedProducts.add(hit.source()));
        } catch (ElasticsearchException | IOException e) {
            throw new Exception(e.getMessage(), e.getCause());
        }

        return recommendedProducts.stream().map((product) -> product.getName()).toList();
    }
}
