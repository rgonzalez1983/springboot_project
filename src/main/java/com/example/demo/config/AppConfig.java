package com.example.demo.config;

import com.example.demo.interceptor.CityInterceptor;
import com.example.demo.interceptor.CountryInterceptor;
import com.example.demo.interceptor.PersonInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CountryInterceptor()).addPathPatterns("/api/country/create", "/api/country/update/**");
        registry.addInterceptor(new CityInterceptor()).addPathPatterns("/api/city/create", "/api/city/update/**");
        registry.addInterceptor(new PersonInterceptor()).addPathPatterns("/api/person/create", "/api/person/update/**");

    }
}
