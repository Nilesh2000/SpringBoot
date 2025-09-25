package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
    private String coursePrefix;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean result;
        if(value != null) {
            result = value.startsWith(coursePrefix);
        } else {
            result = true;
        }
        return result;
    }

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }
}
