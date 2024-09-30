package com.miraijr.command_side.modules.account.adapter.out.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntityJpa, Long> {
  Optional<AccountEntityJpa> findByUsernameAndStatus(String username, String status);

  Optional<AccountEntityJpa> findByUsername(String username);
}
