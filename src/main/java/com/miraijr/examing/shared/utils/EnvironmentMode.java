package com.miraijr.examing.shared.utils;

import java.util.Arrays;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentMode {
  public final String DEV_MODE = "dev";
  private Environment environment;

  public boolean isDevMode() {
    return Arrays.asList(environment.getActiveProfiles()).contains(DEV_MODE);
  }
}
