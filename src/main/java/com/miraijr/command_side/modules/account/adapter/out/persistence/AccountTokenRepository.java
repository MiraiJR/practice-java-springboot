package com.miraijr.command_side.modules.account.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountTokenRepository extends JpaRepository<AccountTokenEntityJpa, Long> {
  @Query("SELECT a FROM AccountTokenEntityJpa a WHERE a.account.id = :accountId ORDER BY a.id ASC")
  List<AccountTokenEntityJpa> findByAccountIdOrderedById(@Param("accountId") Long accountId);

  void deleteByAccessToken(String accessToken);

  void deleteByRefreshToken(String refreshToken);

  Optional<AccountTokenEntityJpa> findByAccessToken(String token);

  Optional<AccountTokenEntityJpa> findByRefreshToken(String token);

  @Modifying
  @Query("DELETE FROM AccountTokenEntityJpa a WHERE a.id = :tokenId")
  void deleteByTokenId(@Param("tokenId") Long tokenId);
}
