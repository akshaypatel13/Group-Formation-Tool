package com.example.CATME.Instructor;

import com.example.CATME.passwordGenerator.PasswordGenerator;
import com.example.CATME.passwordGenerator.PasswordGeneratorImpl;
import com.example.CATME.signup.User;
import com.example.CATME.signup.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

@Controller
public class InstructorControllerImpl implements InstructorController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordGenerator passwordGenerator;

    @GetMapping("/instructor")
    public String instructor(){
        return "instructor";
    }

    @PostMapping("/instructor")
    public String instructorPost(@RequestParam("file")MultipartFile file, Model model){

        if (file.isEmpty()){
            model.addAttribute("message", "Please select a CSV file to upload");
            model.addAttribute("status", false);
        }
        else {
            String row = "";
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){

                while( (row = reader.readLine()) != null){

                    String[] data = row.split(",");
                    addStudents(data);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "instructor";
    }

    @Override
    public boolean addStudents(String[] userDetails) {

        User user = new User();
        user.setEmail(userDetails[0]);
        user.setBannerId(userDetails[1]);
        user.setLastname(userDetails[2]);
        user.setFirstname(userDetails[3]);

        user.setSetPassword(passwordGenerator.generatePassword());
        userService.register(user);
        return true;
    }
}
