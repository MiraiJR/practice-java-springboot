package com.miraijr.examing.modules.account.domain;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.miraijr.examing.modules.account.domain.exceptions.InvalidPassword;

import lombok.Getter;

@Getter
public class Password {
  private final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z]).{8,}$";
  private final Integer MIN_LENGTH = 8;
  private String value;

  public Password(String value) {
    this.setValue(value, false);
  }

  public Password(String value, boolean hashed) {
    this.setValue(value, hashed);
  }

  private void setValue(String value, boolean hashed) {
    if (hashed) {
      this.value = value;
      return;
    }

    if (value.length() < MIN_LENGTH || !value.matches(this.PASSWORD_PATTERN)) {
      throw new InvalidPassword();
    }

    this.value = value;
  }

  public void hash() {
    this.value = BCrypt.hashpw(this.value, BCrypt.gensalt());
  }

  public boolean verify(String password) {
    return BCrypt.checkpw(password, this.value);
  }
}
