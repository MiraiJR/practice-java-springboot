package com.miraijr.command_side.modules.product.adaper.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntityJpa, Long> {

}
