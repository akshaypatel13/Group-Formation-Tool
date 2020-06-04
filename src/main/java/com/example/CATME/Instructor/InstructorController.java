package com.example.CATME.Instructor;

import com.example.CATME.database.UserSignUpDB;

public interface InstructorController {

    boolean addStudents(String[] details, String password, int courseID, String courseName, UserSignUpDB userService);
}

