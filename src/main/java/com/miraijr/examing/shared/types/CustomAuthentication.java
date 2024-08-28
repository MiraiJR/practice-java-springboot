package com.miraijr.examing.shared.types;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class CustomAuthentication implements Authentication {
  private final Long userId;
  private final Long tokenId;
  private boolean authenticated = false;

  public CustomAuthentication(Long userId, Long tokenId) {
    this.userId = userId;
    this.tokenId = tokenId;
    this.authenticated = true;
  }

  @Override
  public String getName() {
    return this.userId.toString();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.emptyList();
  }

  @Override
  public Object getCredentials() {
    throw new UnsupportedOperationException("Unimplemented method 'getCredentials'");
  }

  @Override
  public Object getDetails() {
    throw new UnsupportedOperationException("Unimplemented method 'getDetails'");
  }

  @Override
  public Long getPrincipal() {
    return this.userId;
  }

  @Override
  public boolean isAuthenticated() {
    return authenticated;
  }

  public Long getTokenId() {
    return this.tokenId;
  }

  @Override
  public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    this.authenticated = isAuthenticated;
  }
}
