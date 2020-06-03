package com.example.CATME.instructor;

import com.example.CATME.Instructor.InstructorController;
import com.example.CATME.Instructor.InstructorControllerImpl;
import com.example.CATME.passwordGenerator.PasswordGenerator;
import com.example.CATME.passwordGenerator.PasswordGeneratorImpl;
import com.example.CATME.signup.UserService;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructorControllerImplTest {

    @Test
    public void addStudentsTest(){
        String[] userDetails = new String[4];
        userDetails[0] = "abc@dal.ca";
        userDetails[1] = "B0011111";
        userDetails[2] = "lastName";
        userDetails[3] = "firstName";
        UserService userService = new UserServiceMock();
        PasswordGenerator passwordGenerator = new PasswordGeneratorImpl();
        InstructorController instructorController = new InstructorControllerImpl(userService, passwordGenerator);
        assertEquals(true,
                instructorController.addStudents(userDetails, userService) );
    }
}
