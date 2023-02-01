package ru.education.recommendationClient.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AnimeClientConfig.class)
public class ApplicationConfig {
}
