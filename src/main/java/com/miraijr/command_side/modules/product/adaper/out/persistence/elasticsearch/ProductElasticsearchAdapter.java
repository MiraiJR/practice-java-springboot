package com.miraijr.command_side.modules.product.adaper.out.persistence.elasticsearch;

import org.springframework.stereotype.Component;

import com.miraijr.command_side.modules.product.adaper.mapping.ProductMapping;
import com.miraijr.command_side.modules.product.domain.Product;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductElasticsearchAdapter {
  private final ProductElasticsearchRepository productElasticsearchRepository;
  private final ProductMapping productMapping;

  public void insertProduct(Product product) {
    ProductEntityElasticsearch entity = this.productMapping.convertFromDomainEntityToElasticsearchEntity(product);
    this.productElasticsearchRepository.save(entity);
  }
}
