package com.miraijr.command_side.core.infrastruction.external_services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.miraijr.command_side.core.infrastruction.external_services.out.TokenHandlerPort;
import com.miraijr.command_side.shared.types.enums.TokenType;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService implements TokenHandlerPort {
  @Value("${token.access.signing.key}")
  private String JWT_ACCESS_SIGNING_KEY;

  @Value("${token.refresh.signing.key}")
  private String JWT_REFRESH_SIGNING_KEY;

  public Long extractUserId(String token, TokenType type) {
    return Long.valueOf(extractClaim(token, Claims::getSubject, type));
  }

  public String generateToken(Long userId, TokenType type) {
    return generateToken(new HashMap<>(), userId, type);
  }

  private String generateToken(Map<String, Object> extraClaims, Long id, TokenType type) {
    return Jwts.builder()
        .claims(extraClaims)
        .subject(id.toString())
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * (type == TokenType.REFRESH ? 7 : 1)))
        .signWith(getSigningKey(type))
        .compact();
  }

  public boolean isTokenExpired(String token, TokenType type) {
    return extractExpiration(token, type).before(new Date());
  }

  private Date extractExpiration(String token, TokenType type) {
    return extractClaim(token, Claims::getExpiration, type);
  }

  private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers, TokenType type) {
    final Claims claims = extractAllClaims(token, type);
    return claimsResolvers.apply(claims);
  }

  private Claims extractAllClaims(String token, TokenType type) {
    return Jwts.parser()
        .verifyWith(getSigningKey(type))
        .build()
        .parseSignedClaims(token)
        .getPayload();
  }

  private SecretKey getSigningKey(TokenType type) {
    byte[] keyBytes = Decoders.BASE64
        .decode(type == TokenType.ACCESS ? JWT_ACCESS_SIGNING_KEY : JWT_REFRESH_SIGNING_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
