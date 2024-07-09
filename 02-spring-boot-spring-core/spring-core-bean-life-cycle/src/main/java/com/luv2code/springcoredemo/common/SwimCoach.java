package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Bean;

public class SwimCoach implements Coach {
    public SwimCoach(){
        System.out.println("SwimCoach constructor");
    }

    @Override
    public String GetDailyWorkout(){
        return "Swim Coach says : Back Swim for 20 minutes";
    }
}
