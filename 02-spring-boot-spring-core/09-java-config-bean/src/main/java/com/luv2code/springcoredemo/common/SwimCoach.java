package com.luv2code.springcoredemo.common;

// SwimCoach did not have @Component
// Instead, we configured it as a Spring bean using @Bean
public class SwimCoach implements Coach {
    public SwimCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 metres as a warm up";
    }
}
