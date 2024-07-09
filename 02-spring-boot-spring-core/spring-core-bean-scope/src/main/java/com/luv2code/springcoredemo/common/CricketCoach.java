package com.luv2code.springcoredemo.common;

import ch.qos.logback.core.net.SyslogOutputStream;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Component makes this class available as a bean for dependency injection
@Component
@Primary // make this the primary/default coach
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("CricketCoach constructor");
    }
    @Override
    public String GetDailyWorkout(){
        return "Cricket Coach says : Jumping Jacks for 20 minutes";
    }
}
