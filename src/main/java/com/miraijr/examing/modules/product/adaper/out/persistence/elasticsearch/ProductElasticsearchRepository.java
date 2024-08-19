package com.miraijr.examing.modules.product.adaper.out.persistence.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductElasticsearchRepository extends ElasticsearchRepository<ProductEntityElasticsearch, Long> {

}
