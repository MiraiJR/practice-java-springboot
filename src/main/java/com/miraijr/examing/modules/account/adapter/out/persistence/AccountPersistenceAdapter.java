package com.miraijr.examing.modules.account.adapter.out.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.miraijr.examing.modules.account.application.port.out.CreateAccountPort;
import com.miraijr.examing.modules.account.application.port.out.LoadAccountPort;
import com.miraijr.examing.modules.account.application.port.out.UpdateAccountPort;
import com.miraijr.examing.modules.account.common.mapping.AccountMapping;
import com.miraijr.examing.modules.account.domain.Account;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AccountPersistenceAdapter implements LoadAccountPort, CreateAccountPort, UpdateAccountPort {
  private final AccountRepository accountRepository;
  private final AccountMapping accountMapping;

  @Override
  public Optional<Account> loadAccountByUsername(String username) {
    Optional<AccountEntityJpa> account = this.accountRepository.findByUsername(username);
    return account.isPresent() ? Optional.of(this.accountMapping.convertFromJpaEntityToDomainEntity(account.get()))
        : Optional.empty();
  }

  @Override
  public void createAccount(Account account) {
    AccountEntityJpa accountEntity = this.accountMapping.convertFromDomainEntityToJpaEntity(account);
    this.accountRepository.save(accountEntity);
  }

  @Override
  public void updateAccount(Account account) {
    AccountEntityJpa accountEntity = this.accountMapping.convertFromDomainEntityToJpaEntity(account);
    this.accountRepository.save(accountEntity);
  }
}
