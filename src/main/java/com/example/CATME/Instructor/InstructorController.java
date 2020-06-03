package com.example.CATME.Instructor;

import com.example.CATME.signup.UserSignUpService;

public interface InstructorController {

    boolean addStudents(String[] details, UserSignUpService userService);
}
