package com.miraijr.command_side.core.infrastruction.security;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.miraijr.command_side.core.domain.acount.AccountToken;
import com.miraijr.command_side.core.infrastruction.external_services.out.TokenHandlerPort;
import com.miraijr.command_side.core.infrastruction.security.exceptions.ExpiredTokenException;
import com.miraijr.command_side.core.infrastruction.security.exceptions.InvalidTokenException;
import com.miraijr.command_side.modules.account.application.port.out.LoadAccountTokenPort;
import com.miraijr.command_side.shared.types.CustomAuthentication;
import com.miraijr.command_side.shared.types.enums.TokenType;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  private static String BEARER = "Bearer ";
  private static String AUTHORIZATION_KEY = "Authorization";
  private final TokenHandlerPort tokenHandlerPort;
  private final LoadAccountTokenPort loadAccountTokenPort;
  private static final List<Pair<String, String>> BYPASS_TOKENS = Arrays.asList(
      Pair.of("/accounts/register", "POST"),
      Pair.of("/accounts/login", "POST"),
      Pair.of("/actuator/health", "GET"),
      Pair.of("/products/recommend", "GET"),
      Pair.of("/categories", "GET"));

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    if (isBypassToken(request)) {
      filterChain.doFilter(request, response);
      return;
    }

    String token = this.getToken(request);
    AccountToken accountToken = this.checkToken(token);
    CustomAuthentication customAuthentication = new CustomAuthentication(accountToken.getAccountId(),
        accountToken.getId());
    customAuthentication.setAuthenticated(true);
    SecurityContextHolder.getContext().setAuthentication(customAuthentication);
    filterChain.doFilter(request, response);
  }

  private boolean isBypassToken(HttpServletRequest request) {
    String requestPath = request.getServletPath();
    String requestMethod = request.getMethod();

    return BYPASS_TOKENS.contains(Pair.of(requestPath, requestMethod));
  }

  private String getToken(HttpServletRequest request) {
    String authHeader = request.getHeader(AUTHORIZATION_KEY);
    if (authHeader == null || !authHeader.startsWith(BEARER)) {
      throw new InvalidTokenException();
    }

    return authHeader.substring(BEARER.length());
  }

  private AccountToken checkToken(String token) {
    try {
      this.tokenHandlerPort.isTokenExpired(token, TokenType.ACCESS);
    } catch (Exception e) {
      throw new ExpiredTokenException();
    }

    Optional<AccountToken> matchedToken = this.loadAccountTokenPort.loadTokenByAccessToken(token);
    if (matchedToken.isEmpty()) {
      throw new InvalidTokenException();
    }

    return matchedToken.get();
  }
}
