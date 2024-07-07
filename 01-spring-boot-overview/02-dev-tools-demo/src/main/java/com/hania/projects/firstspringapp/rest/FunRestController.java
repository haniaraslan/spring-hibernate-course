package com.hania.projects.firstspringapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 @RestController
public class FunRestController{
     // expose "/" that returns "Hello World!"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    // expose new endpoint for"workout"
     @GetMapping("/workout")
     public String getDailyWorkout(){
        return "Run a hard 5k!";
     }

     // expose new endpoint for"workout"
     @GetMapping("/home")
     public String goHome(){
         return "Welcome Home!";
     }

     //inject properties for: coach.name, team.name
     @Value("${coach.name}")
     private String coachName;

     @Value("${team.name}")
     private String teamName;

     // expose new endpt teamInfo
     @GetMapping("/teaminfo")
     public String getTeamInfo(){
         return "Coach: "+ coachName + " , Team: " + teamName;
     }
}
