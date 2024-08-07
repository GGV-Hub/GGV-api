package com.ggv.domain.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EntityScan("com.ggv.domain")
@EnableJpaAuditing
public class JpaConfig {
}
