package com.dor.couponsprojectapp.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class YAMLConfig {
    public static String jwtsecret;
}
