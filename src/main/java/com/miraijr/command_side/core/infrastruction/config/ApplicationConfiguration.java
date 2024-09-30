package com.miraijr.command_side.core.infrastruction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import com.github.slugify.Slugify;

@Configuration
@EnableAspectJAutoProxy
public class ApplicationConfiguration {
  @Bean
  Slugify slugify() {
    return new Slugify();
  }
}
