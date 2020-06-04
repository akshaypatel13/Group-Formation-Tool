package com.example.CATME.Instructor;

import com.example.CATME.database.UserSignUpDB;

public interface InstructorController {

    boolean addStudents(String[] details, int courseID, String courseName, UserSignUpDB userService);
}

