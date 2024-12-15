package com.luv2code.springdemo.mcv;

import com.luv2code.springdemo.mcv.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;
    @NotNull(message = "required")
    @Size(min=1, message = "required")
    private String lastName = "";

    @Min(value = 0, message = "Min 0")
    @Max(value = 10, message = "Max 10")
    @NotNull(message = "required")
    private Integer freePasses;

    @NotNull(message = "required")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 digits allowed")
    private String postalCode;

    @CourseCode(value = "CSE", message = "Must start wit CSE")
    private String courseCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
