package com.example.CATME.signup;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.CATME.admin.*;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.Assert.*;
import java.util.ArrayList;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class courseServiceTest {

    @Mock
    private courseDaoImpl dao;

    @InjectMocks
    private courseServiceImpl service;

    @Test
    public void getCoursesTest(){
        ArrayList<courseModel> courses=new ArrayList<courseModel>();
        courseModel course = new courseModel();
        course.setCourse_id(1);
        course.setCourse_code("CSCI-5308");
        course.setCourse_name("Cloud Computing");
        course.setTerm("summer");
        course.setYear(2020);
        given(dao.getAllCourses()).willReturn(courses);
        ArrayList<courseModel> expected_courses=service.getCourses();
        assertEquals(expected_courses,courses);


    }

    @Test
    public void deleteCourseTest(){
        String result="Course Deleted Successfully";
        int course_id=1;
        given(dao.deleteCourses(course_id)).willReturn(true);
        assertEquals(result,service.deleteCourse(course_id));
    }

    @Test
    public void deleteCourseNullTest(){
        String result="Course Not Deleted";
        int course_id=0;
        given(dao.deleteCourses(course_id)).willReturn(false);
        assertEquals(result,service.deleteCourse(course_id));
    }

    @Test
    public void getUserTest(){
        ArrayList<userModel> users=new ArrayList<userModel>();
        userModel user = new userModel();
        user.setUsername("akshay@gmail.com");
        user.setFirst_name("akshay");
        user.setLast_name("patel");
        user.setBanner_id("B00854211");
        user.setEnabled(1);
        user.setUser_id("abcd123");
        user.setPassword("abcd@1234");
        users.add(new userModel(user.getUsername(),user.getFirst_name(),user.getLast_name(),user.getPassword()
        ,user.getEnabled(),user.getBanner_id(),user.getUser_id()));

        given(dao.getAllUsers()).willReturn(users);
        ArrayList<userModel> expected_users=service.getUsers();
        assertEquals(expected_users,users);


    }

    @Test
    public void InsertInstructorTest(){
        String result="Instructor Not Inserted";
        authoritiesModel roles=new authoritiesModel();
        roles.setAuthority("ROLES_INSTRUCTOR");
        roles.setUsername("akshay123@gmail.com");
        roles.setCourse_id(3);
        given(dao.addInstructor(roles.getUsername(),roles.getAuthority(),roles.getCourse_id())).willReturn(true);
        assertEquals(result,service.insertInstructor(3,"akshay123@gmail.com"));
    }

    @Test
    public void insertCourseTest(){
        String result="Course Inserted Successfully";
        courseModel course=new courseModel();
        course.setCourse_name("Adv. SDC");
        course.setTerm("summer");
        course.setYear(2020);
        course.setCourse_code("CSCI-28");
        given(dao.addCourse(course.getCourse_code(),course.getCourse_name(),course.getTerm(),course.getYear())).willReturn(true);
        assertEquals(result,service.insertCourse("CSCI-28","Adv. SDC","summer",2020));


    }

    @Test
    public void searchInstructorTest(){
        userModel user=new userModel();
        user.setUser_id("124");
        user.setBanner_id("B00");
        user.setPassword("abcd@12");
        user.setEnabled(1);
        user.setUsername("abcd@1234");
        user.setLast_name("bcd");
        user.setFirst_name("akshay");
        given(dao.searchByBannerID(user.getBanner_id())).willReturn(user);
        userModel expected_user=service.searchInstructor("B00");
        assertEquals(expected_user,user);
    }

}
