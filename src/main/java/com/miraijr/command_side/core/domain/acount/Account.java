package com.miraijr.command_side.core.domain.acount;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Account {
  protected Long id;
  protected LocalDateTime createdAt;
  protected String username;
  protected Password password;
  protected LocalDateTime latestLogin;
  protected Status status;

  public void hashPassword() {
    this.password.hash();
  }

  public boolean verifyPassword(String rawPassword) {
    return this.password.verify(rawPassword);
  }

  public void updateStatus(String status) {
    this.status = new Status(status);
  }

  public void updateLatestLogin() {
    this.latestLogin = LocalDateTime.now();
  }
}
