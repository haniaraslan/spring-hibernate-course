package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;
    // @autowired tells spring to inject dependency
    // dependency injection with constructor

    // the default scope is singleton for the bean
    @Autowired
    public DemoController (@Qualifier("cricketCoach") Coach theCoach,@Qualifier("cricketCoach") Coach theOtherCoach){
        System.out.println("DemoController constructor");
        myCoach = theCoach;
        anotherCoach = theOtherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.GetDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){return "comparing beans myCoach == anotherCoach is " + (myCoach == anotherCoach);}
}
