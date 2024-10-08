package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    // @autowired tells spring to inject dependency
    // dependency injection with constructor

    // the default scope is singleton for the bean
    @Autowired
    public DemoController (@Qualifier("swimCoach") Coach theCoach){
        System.out.println("DemoController constructor");
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.GetDailyWorkout();
    }

}
