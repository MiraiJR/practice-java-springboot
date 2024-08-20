package com.miraijr.examing.core.infrastruction.external_services;

import java.util.Map;

import org.springframework.stereotype.Component;
import com.github.slugify.Slugify;
import com.miraijr.examing.core.infrastruction.external_services.out.SlugGeneratorPort;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SlugGeneratorService implements SlugGeneratorPort {
  private final Slugify slugify;

  @Override
  public String generateSlug(String value) {
    String slug = slugify.withLowerCase(true)
        .withCustomReplacements(Map.of("đ", "d", "Đ", "d"))
        .slugify(value);

    long timestamp = System.currentTimeMillis() / 1000L;
    return slug + "-" + timestamp;
  }
}
