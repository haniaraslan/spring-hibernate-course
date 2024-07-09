package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

// @Component makes this class available as a bean for dependency injection
@Component
public class BaseballCoach implements Coach {

    public BaseballCoach(){
        System.out.println("BaseballCoach constructor");
    }
    @Override
    public String GetDailyWorkout(){
        return "Baseball Coach says : Run fast for 20 minutes";
    }
}
