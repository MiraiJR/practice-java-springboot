package com.miraijr.examing.modules.product.adaper.out.persistence.elasticsearch;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.miraijr.examing.modules.product.application.port.out.LoadRecommendProductNamePort;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductElasticsearchQuery implements LoadRecommendProductNamePort {
    private final ElasticsearchClient elasticsearchClient;
    private static final String INDEX = "products";

    @Override
    public List<String> loadRecommendProductName(String prompt) {
        List<ProductEntityElasticsearch> recommendedProducts = new ArrayList<>();
        try {
            SearchResponse<ProductEntityElasticsearch> search = this.elasticsearchClient.search(s -> s
                    .index(INDEX)
                    .query(q -> q
                            .multiMatch(t -> t
                                    .query(prompt)
                                    .fields(List.of("name", "description", "categoryName"))
                                    .fuzziness("AUTO"))),
                    ProductEntityElasticsearch.class);

            search.hits().hits().forEach(hit -> recommendedProducts.add(hit.source()));
        } catch (Exception e) {
            System.out.println("Elasticsearch query failed: " + e.getMessage());
        }

        return recommendedProducts.stream().map((product) -> product.getName()).toList();
    }
}
