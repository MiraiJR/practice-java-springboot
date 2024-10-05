package com.miraijr.command_side.modules.product.adaper.out.persistence.elasticsearch;

import org.springframework.stereotype.Component;

import com.miraijr.command_side.modules.product.adaper.mapping.CategoryMapping;
import com.miraijr.command_side.modules.product.domain.Category;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CategoryElasticsearchAdapter {
    private final CategoryElasticsearchRepository categoryElasticsearchRepository;
    private final CategoryMapping categoryMapping;

    public void insertCategory(Category category) {
        CategoryEntityElasticsearch entity = this.categoryMapping
                .convertFromDomainEntityToElasticsearchEntity(category);
        this.categoryElasticsearchRepository.save(entity);
    }
}
