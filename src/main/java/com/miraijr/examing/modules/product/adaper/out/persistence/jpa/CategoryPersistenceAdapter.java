package com.miraijr.examing.modules.product.adaper.out.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.miraijr.examing.modules.product.adaper.mapping.CategoryMapping;
import com.miraijr.examing.modules.product.application.port.out.CreateCategoryPort;
import com.miraijr.examing.modules.product.application.port.out.LoadCategoryPort;
import com.miraijr.examing.modules.product.domain.Category;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CategoryPersistenceAdapter implements LoadCategoryPort, CreateCategoryPort {
  private final CategoryRepository categoryRepository;
  private final CategoryMapping categoryMapping;

  @Override
  public Category createCategory(Category category) {
    CategoryEntityJpa entity = this.categoryMapping.convertFromDomainEntityToJpaEntity(category);
    CategoryEntityJpa newEntity = this.categoryRepository.save(entity);
    return this.categoryMapping.convertFromJpaEntityToDomainEntity(newEntity);
  }

  @Override
  public Optional<Category> loadCategory(Long id) {
    Optional<CategoryEntityJpa> entityJpa = this.categoryRepository.findById(id);
    return entityJpa.isPresent() ? Optional.of(this.categoryMapping.convertFromJpaEntityToDomainEntity(entityJpa.get()))
        : Optional.empty();
  }

  @Override
  public List<Category> loadCategories() {
    List<CategoryEntityJpa> entityJpas = this.categoryRepository.findAll();

    return entityJpas.stream()
        .map(this.categoryMapping::convertFromJpaEntityToDomainEntity)
        .toList();
  }
}
