package com.miraijr.command_side.core.infrastruction.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.miraijr.command_side.shared.annotations.UserIdArgumentResolver;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    argumentResolvers.add(new UserIdArgumentResolver());
  }
}
