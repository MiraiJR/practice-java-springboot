package com.miraijr.examing.modules.account.application.port.in;

import com.miraijr.examing.modules.account.application.port.in.input.ChangeAccountStatusInputModel;

public interface UpdateAccountUseCase {
  public void changeStatusAccount(ChangeAccountStatusInputModel changeAccountStatusInputModel);
}
