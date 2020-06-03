package com.example.CATME.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
public class AdminController {

    courseServiceImpl course_service=new courseServiceImpl();

    @RequestMapping("/admin")
    public String adminPage(Model model) {
        ArrayList<courseModel> courses=course_service.getCourses();
        if(courses.isEmpty()){
            model.addAttribute("status","No Courses Present in the DB");
        }else {
            model.addAttribute("courses", courses);
        }
        return "admin";
    }

    @RequestMapping("/searchBanner")
    public String searchBannerId(Model model,@RequestParam(name="bannerid") String banner_id){
        userModel user=new userModel();
        if(user==null){
            model.addAttribute("status","No Users found with given BannerID.");
        }else {
            model.addAttribute("users", user);
        }
        return "addInstructor";
    }
    @RequestMapping("/deleteCourse")
    public String deleteCourse(Model model,@RequestParam(name="course_id") int course_id) {
        System.out.print(course_service.deleteCourse(course_id));
        model.addAttribute("status", course_service.deleteCourse(course_id));
        model.addAttribute("courses",course_service.getCourses());
        return "admin";
    }

    @RequestMapping("/addInstructor")
    public String addInstructor(Model model,@RequestParam(name="course_id") String course_id) {
        model.addAttribute("users",course_service.getUsers());
        model.addAttribute("course_id", course_id);
        return "addInstructor";
    }

    @RequestMapping("/insertInst")
    public String insertInstructor(Model model,@RequestParam(name="course_id") int course_id, @RequestParam(name="username") String username) {
        model.addAttribute("status", course_service.insertInstructor(course_id,username));
        model.addAttribute("courses",course_service.getCourses());
        return "admin";
    }

    @RequestMapping("/insertCourse")
    public String addCourse(Model model,@RequestParam(name="course_name") String course_name,@RequestParam(name="course_code") String course_code,
                            @RequestParam(name="term") String term,
                            @RequestParam(name="year") int year) {
        model.addAttribute("status", course_service.insertCourse(course_code,course_name, term, year));
        model.addAttribute("courses",course_service.getCourses());
        return "admin";
    }

}
