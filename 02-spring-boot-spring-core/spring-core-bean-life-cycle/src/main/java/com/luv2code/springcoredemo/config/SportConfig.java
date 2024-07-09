package com.luv2code.springcoredemo.config;

import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
 this configuration is normally used with third party apps when we cannot simply add @Component to the class so we have
 to configure it manually and add its bean to be available as a component, ex: AWS s3
 */
@Configuration
public class SportConfig {
    @Bean
    // can also be @Bean("id") and use this id in the Qualifier instead of the class name
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
