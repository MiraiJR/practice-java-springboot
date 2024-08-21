package com.miraijr.examing.modules.user.adapter.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntityJpa, Long> {
  Optional<UserEntityJpa> findById(Long id);
}
