package com.luv2code.springcoredemo.common;

import ch.qos.logback.core.net.SyslogOutputStream;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Component makes this class available as a bean for dependency injection
@Component
@Primary // make this the primary/default coach
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("CricketCoach constructor");
    }

    // define init method
    @PostConstruct
    public void startUp(){
        System.out.println("CricketCoach Start Up! " + getClass().getSimpleName());
    }

    // define destroy method
    @PreDestroy
    public void clearAll(){
        System.out.println("CricketCoach Clear All! " + getClass().getSimpleName());
    }

    @Override
    public String GetDailyWorkout(){
        return "Cricket Coach says : Jumping Jacks for 20 minutes";
    }
}
