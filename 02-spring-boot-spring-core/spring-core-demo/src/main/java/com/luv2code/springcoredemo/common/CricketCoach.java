package com.luv2code.springcoredemo.common;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// @Component makes this class available as a bean for dependency injection
@Component
@Primary // make this the primary/default coach
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("CricketCoach constructor");
    }
    @Override
    public String GetDailyWorkout(){
        return "Cricket Coach says : Jumping Jacks for 20 minutes";
    }
}
