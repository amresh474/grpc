package com.dplaps.catalogs.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfig {
    @Value("${service2.url}")
    public String service2Url;

    @Value("${service3.url}")
    public String service3Url;

}