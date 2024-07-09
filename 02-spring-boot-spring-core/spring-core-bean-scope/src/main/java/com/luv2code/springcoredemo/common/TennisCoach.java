package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

// @Component makes this class available as a bean for dependency injection
@Component
public class TennisCoach implements Coach {

    public TennisCoach(){
        System.out.println("TennisCoach constructor");
    }
    @Override
    public String GetDailyWorkout(){
        return "Tennis Coach says : throw ball for 50 times";
    }
}
