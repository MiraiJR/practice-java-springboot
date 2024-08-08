package com.miraijr.examing.modules.account.adapter.out.persistence;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accounts", indexes = @Index(name = "account_idx", columnList = "username"))
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntityJpa {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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
  @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<AccountTokenEntityJpa> accountTokens;

  @PrePersist
  void preInsert() {
    this.createdAt = LocalDateTime.now();
  }
}
