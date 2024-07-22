package com.miraijr.examing.modules.account.application;

import java.util.Optional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.miraijr.examing.modules.account.application.exceptions.AccountNotFoundException;
import com.miraijr.examing.modules.account.application.port.in.LogoutAccountUseCase;
import com.miraijr.examing.modules.account.application.port.out.AccountEventToKafkaPort;
import com.miraijr.examing.modules.account.application.port.out.LoadAccountPort;
import com.miraijr.examing.modules.account.application.port.out.UpdateAccountPort;
import com.miraijr.examing.modules.account.application.port.out.input.RemoveAccountTokenInputModel;
import com.miraijr.examing.modules.account.domain.Account;
import com.miraijr.examing.shared.types.CustomAuthentication;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class LogoutAccount implements LogoutAccountUseCase {
  private final LoadAccountPort loadAccountPort;
  private final UpdateAccountPort updateAccountPort;
  private final AccountEventToKafkaPort sendMessageToKafkaPort;

  @Override
  @Transactional("transactionManager")
  public String execute(Long accountId) {
    Optional<Account> matchedAccount = this.loadAccountPort.loadAccountById(accountId);

    if (matchedAccount.isEmpty()) {
      throw new AccountNotFoundException();
    }

    Long tokenId = this.getTokenId();
    this.updateAccountPort.updateAccount(matchedAccount.get());
    this.sendMessageToKafkaPort.sendRemoveTokenTopic(new RemoveAccountTokenInputModel(tokenId));

    return "Logout successfully!";
  }

  private Long getTokenId() {
    CustomAuthentication authentication = (CustomAuthentication) SecurityContextHolder.getContext().getAuthentication();

    Long tokenId = (Long) authentication.getTokenId();
    return tokenId;
  }
}
