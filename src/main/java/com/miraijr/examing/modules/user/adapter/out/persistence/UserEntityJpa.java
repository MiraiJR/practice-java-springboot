package com.miraijr.examing.modules.user.adapter.out.persistence;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntityJpa {
  @Id
  private Long id;

  @Column(name = "full_name", nullable = false)
  private String fullName;

  @Column
  private String email;

  @Column(name = "phone_number")
  private String phoneNumber;

  @OneToMany(mappedBy = "user", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
  private List<AddressEntityJpa> addresses;
}
