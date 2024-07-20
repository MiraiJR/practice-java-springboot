package com.miraijr.examing.modules.account.adapter.out.persistence;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accounts")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntityJpa {
  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "created_at")
  private LocalDateTime createdAt;
  @Column(length = 255, nullable = false)
  private String username;
  @Column(nullable = false)
  private String password;
  @Column(name = "access_token")
  private String accessToken;
  @Column(name = "refresh_token")
  private String refreshToken;
  @Column(name = "latest_login")
  private LocalDateTime latestLogin;
  @Column(nullable = false)
  private String status;

  @PrePersist
  void preInsert() {
    this.createdAt = LocalDateTime.now();
  }
}
