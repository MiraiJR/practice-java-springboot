package com.miraijr.command_side.modules.account.application.port.in;

import com.miraijr.command_side.modules.account.application.port.in.input.ChangeAccountStatusInputModel;

public interface UpdateAccountUseCase {
  public void changeStatusAccount(ChangeAccountStatusInputModel changeAccountStatusInputModel);
}
