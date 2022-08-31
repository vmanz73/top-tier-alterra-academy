package com.vmanmedia.books.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebSocketConfig implements WebMvcConfigurer {

    public void addResourceHandler(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/").addResourceLocations("classpath:/public/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
    }

}
