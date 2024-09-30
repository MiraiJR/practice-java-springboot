package com.miraijr.command_side.modules.account.adapter.out.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

import com.miraijr.command_side.core.domain.acount.AccountToken;
import com.miraijr.command_side.modules.account.adapter.mapping.AccountTokenMapping;
import com.miraijr.command_side.modules.account.application.port.out.CreateAccountTokenPort;
import com.miraijr.command_side.modules.account.application.port.out.DeleteAccountTokenPort;
import com.miraijr.command_side.modules.account.application.port.out.LoadAccountTokenPort;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AccountTokenPersistenceAdapter
    implements CreateAccountTokenPort, LoadAccountTokenPort, DeleteAccountTokenPort {
  private final AccountTokenRepository accountTokenRepository;
  private final AccountTokenMapping accountTokenMapping;

  @Override
  public List<AccountToken> loadTokensByAccount(Long accountId) {
    List<AccountTokenEntityJpa> tokenEntities = this.accountTokenRepository.findByAccountIdOrderedById(accountId);
    return tokenEntities.stream()
        .map(accountTokenMapping::convertFromJpaEntityToDomainEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void createAccountToken(AccountToken accountToken) {
    AccountTokenEntityJpa tokenEntity = this.accountTokenMapping.convertFromDomainEntityToJpaEntity(accountToken);
    this.accountTokenRepository.save(tokenEntity);
  }

  @Override
  public void deleteByAccessToken(String token) {
    this.deleteByAccessToken(token);
  }

  @Override
  public void deleteByRefreshToken(String token) {
    this.deleteByRefreshToken(token);
  }

  @Override
  public Optional<AccountToken> loadTokenByAccessToken(String token) {
    Optional<AccountTokenEntityJpa> accountToken = this.accountTokenRepository.findByAccessToken(token);
    return accountToken.isPresent()
        ? Optional.of(this.accountTokenMapping.convertFromJpaEntityToDomainEntity(accountToken.get()))
        : Optional.empty();
  }

  @Override
  public Optional<AccountToken> loadTokenByRefreshToken(String token) {
    Optional<AccountTokenEntityJpa> accountToken = this.accountTokenRepository.findByRefreshToken(token);
    return accountToken.isPresent()
        ? Optional.of(this.accountTokenMapping.convertFromJpaEntityToDomainEntity(accountToken.get()))
        : Optional.empty();
  }

  @Override
  public void deleteById(Long tokenId) {
    this.accountTokenRepository.deleteByTokenId(tokenId);
  }
}
