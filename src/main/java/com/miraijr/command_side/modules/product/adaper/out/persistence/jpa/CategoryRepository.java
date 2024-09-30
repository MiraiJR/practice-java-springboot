package com.miraijr.command_side.modules.product.adaper.out.persistence.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntityJpa, Long> {
  Optional<CategoryEntityJpa> findById(Long id);
}
