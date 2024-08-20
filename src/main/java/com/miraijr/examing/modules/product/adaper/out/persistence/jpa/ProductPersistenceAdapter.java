package com.miraijr.examing.modules.product.adaper.out.persistence.jpa;

import org.springframework.stereotype.Component;

import com.miraijr.examing.modules.product.adaper.mapping.ProductMapping;
import com.miraijr.examing.modules.product.application.port.out.CreateProductPort;
import com.miraijr.examing.modules.product.domain.Product;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductPersistenceAdapter implements CreateProductPort {
  private final ProductRepository productRepository;
  private final ProductMapping productMapping;

  @Override
  public Product createProduct(Product product) {
    ProductEntityJpa productEntity = productMapping.convertFromDomainEntityToJpaEntity(product);
    ProductEntityJpa newProduct = this.productRepository.save(productEntity);
    return this.productMapping.convertFromJpaEntityToDomainEntity(newProduct);
  }
}
