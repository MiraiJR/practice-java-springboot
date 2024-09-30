package com.miraijr.command_side.modules.account.adapter.out.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.miraijr.command_side.core.domain.acount.Account;
import com.miraijr.command_side.modules.account.adapter.mapping.AccountMapping;
import com.miraijr.command_side.modules.account.application.port.out.CreateAccountPort;
import com.miraijr.command_side.modules.account.application.port.out.DeleteAccountPort;
import com.miraijr.command_side.modules.account.application.port.out.LoadAccountPort;
import com.miraijr.command_side.modules.account.application.port.out.UpdateAccountPort;
import com.miraijr.command_side.modules.account.common.types.enums.AccountStatus;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AccountPersistenceAdapter
    implements LoadAccountPort, CreateAccountPort, UpdateAccountPort, DeleteAccountPort {
  private final AccountRepository accountRepository;
  private final AccountMapping accountMapping;

  @Override
  public Optional<Account> loadAccountByUsername(String username) {
    Optional<AccountEntityJpa> account = this.accountRepository.findByUsernameAndStatus(username,
        AccountStatus.ACTIVE.toString());
    return account.isPresent() ? Optional.of(this.accountMapping.convertFromJpaEntityToDomainEntity(account.get()))
        : Optional.empty();
  }

  @Override
  public Long createAccount(Account account) {
    AccountEntityJpa accountEntity = this.accountMapping.convertFromDomainEntityToJpaEntity(account);
    AccountEntityJpa savedEntity = this.accountRepository.save(accountEntity);
    return savedEntity.getId();
  }

  @Override
  public void updateAccount(Account account) {
    AccountEntityJpa accountEntity = this.accountMapping.convertFromDomainEntityToJpaEntity(account);
    this.accountRepository.save(accountEntity);
  }

  @Override
  public Optional<Account> loadAccountById(Long accountId) {
    Optional<AccountEntityJpa> account = this.accountRepository.findById(accountId);
    return account.isPresent() ? Optional.of(this.accountMapping.convertFromJpaEntityToDomainEntity(account.get()))
        : Optional.empty();
  }

  @Override
  public void deleteAccount(Long accountId) {
    this.accountRepository.deleteById(accountId);
  }
}
