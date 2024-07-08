package com.miraijr.examing.account.adapter.out.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntityJpa, Long> {
  Optional<AccountEntityJpa> findByUsername(String username);
}
