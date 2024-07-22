package com.miraijr.examing.modules.account.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Account {
  private Long id;
  private LocalDateTime createdAt;
  private String username;
  private Password password;
  private LocalDateTime latestLogin;
  private Status status;

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
