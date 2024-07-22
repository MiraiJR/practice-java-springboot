package com.miraijr.examing.modules.accountToken.adapter.out.persistence;

import com.miraijr.examing.modules.account.adapter.out.persistence.AccountEntityJpa;
import com.miraijr.examing.shared.types.enums.DeviceType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account_tokens")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountTokenEntityJpa {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "access_token", nullable = false)
  private String accessToken;
  @Column(name = "refresh_token", nullable = false)
  private String refreshToken;
  @Enumerated(EnumType.STRING)
  @Column(name = "device", nullable = false)
  private DeviceType device;
  @ManyToOne
  @JoinColumn(name = "account_id", nullable = false)
  private AccountEntityJpa account;
}
