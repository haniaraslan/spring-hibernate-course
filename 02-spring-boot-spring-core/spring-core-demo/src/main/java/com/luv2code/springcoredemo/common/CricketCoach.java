package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

// @Component makes this class available as a bean for dependency injection
@Component
public class CricketCoach implements Coach {

    @Override
    public String GetDailyWorkout(){
        return "Jumping Jacks for 20 minutes";
    }
}
