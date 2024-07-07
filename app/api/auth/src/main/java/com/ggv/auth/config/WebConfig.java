package com.ggv.auth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods(
                        HEAD.name(),
                        OPTIONS.name(),
                        GET.name(),
                        POST.name(),
                        PUT.name(),
                        PATCH.name(),
                        DELETE.name()
                );
    }
}
