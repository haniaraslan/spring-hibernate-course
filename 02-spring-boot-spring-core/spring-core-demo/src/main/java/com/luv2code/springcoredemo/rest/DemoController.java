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

    /*
    // direct, Qualifier has higher priority than Primary
    @Autowired
    public DemoController (@Qualifier("tennisCoach") Coach theCoach){
        myCoach = theCoach;
    }
    */

    // use the primary coach which is the default coach
    @Autowired
    public DemoController (Coach theCoach){
        System.out.println("DemoController constructor");
        myCoach = theCoach;
    }

    /*
    // dependency injection with setter

    @Autowired
    public void SetCoach(Coach theCoach){
        myCoach = theCoach;
    }
    */
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.GetDailyWorkout();
    }
}
