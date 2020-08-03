package com.dplaps.grpc.client.msgrpcclient.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfig {
    @Value("${catg.grpc.host}")
    public String catHost;

    @Value("${catg.grpc.port}")
    public int catPort;

}