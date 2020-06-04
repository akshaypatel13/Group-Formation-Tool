package com.example.CATME.Instructor;

import com.example.CATME.database.UserResetPasswordDBImpl;
import com.example.CATME.database.UserSignUpDB;
import com.example.CATME.database.UserSignUpDBImpl;
import com.example.CATME.passwordGenerator.PasswordGenerator;
import com.example.CATME.resetpassword.*;
import com.example.CATME.signup.UserSignUpDAO;
import com.example.CATME.signup.UserSignUpDAOImpl;
import com.example.CATME.signup.UserSignUpService;
import com.example.CATME.signup.UserSignUpServiceImpl;
import com.example.CATME.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

@Controller
public class InstructorControllerImpl implements InstructorController {

	UserSignUpDB userService;

    PasswordGenerator passwordGenerator;

    @Autowired
    EmailService emailService;

    public InstructorControllerImpl(PasswordGenerator passwordGenerator){
        this.userService = new UserSignUpDBImpl();
        this.passwordGenerator = passwordGenerator;
    }

    @GetMapping("/instructor")
    public String instructor(Model model){
        model.addAttribute("status", true);
        return "instructor";
    }



    @PostMapping("/instructor/{courseID}/{courseName}")
    public String instructorPost(@PathVariable("courseID") int courseID, @PathVariable("courseName") String courseName, @RequestParam("file")MultipartFile file, Model model, HttpServletResponse response){

        if (file.isEmpty()){
            model.addAttribute("message", "Please select a CSV file to upload");
            model.addAttribute("status", false);

            return "addStudentInstructor";
        }
        else {
            String row = "";
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){

                while( (row = reader.readLine()) != null){

                    String[] data = row.split(",");
                    String password = passwordGenerator.generatePassword();
                    addStudents(data, password, courseID, courseName, userService);
                    emailCredentials(data[0], password, courseName);
                }
                model.addAttribute("status", true);
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("message", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }

        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "instructor";
    }

    @GetMapping("/instructor/addStudent")
    public String courseView(@RequestParam(value = "courseName") String courseName, @RequestParam(value = "courseID") int courseID, Model model) {
        model.addAttribute("courseName", courseName);
        model.addAttribute("courseID", courseID);
        model.addAttribute("status", true);
        return "addStudentInstructor";
    }

    @Override
    public boolean addStudents(String[] userDetails, String password, int courseId, String courseName, UserSignUpDB userService) {

        User user = new User();
        user.setEmail(userDetails[0]);
        user.setBannerId(userDetails[1]);
        user.setLastName(userDetails[2]);
        user.setFirstName(userDetails[3]);
        user.setPassword(password);
        userService.insertStudentUser(user, courseId);
        return true;
    }

    public boolean emailCredentials(String email, String password, String courseName){

        // Email message
        SimpleMailMessage Email = new SimpleMailMessage();
        Email.setFrom("support@group21.com");
        Email.setTo(email);
        Email.setSubject("Account Credentials");
        Email.setText("You have been added to Course: " + courseName + "\n" + "Please find your Login Credentials \nUsername: " + email + "\nPassword: " + password);
       try{
           emailService.sendEmail(Email);
       }
       catch (Exception e){
           System.out.print(e.getMessage());
       }
        return true;
    }
}
