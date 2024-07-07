package com.ggv.externalclient.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationPropertiesScan(basePackages = "com.ggv.externalclient")
@EnableConfigurationProperties
public class PropertiesConfig {
}
