package com.miraijr.command_side.modules.product.adaper.out.persistence.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CategoryElasticsearchRepository extends ElasticsearchRepository<CategoryEntityElasticsearch, Long> {

}
