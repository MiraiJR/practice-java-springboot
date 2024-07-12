package com.miraijr.examing.modules.user.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntityJpa, Long> {
  @SuppressWarnings("null")
  Optional<UserEntityJpa> findById(Long id);
}
