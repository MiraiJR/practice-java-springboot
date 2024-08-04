package com.miraijr.examing.modules.user.adapter.out.persistence.redis;

import java.util.List;

import org.springframework.data.redis.core.RedisHash;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("users")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntityRedis {
  @Id
  private Long id;
  private String fullName;
  private String phoneNumber;
  private String email;
  private List<AddressEntityRedis> addresses;
}
