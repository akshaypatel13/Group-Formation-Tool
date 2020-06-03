package com.example.CATME.adminTest;

import com.example.CATME.admin.*;
import com.example.CATME.admin.courseModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertTrue;

@SpringBootTest
public class courseModelTest {

    @Test
    public void setCourseIdTest(){
        courseModel course=new courseModel();
        course.setCourse_id(1);
        assertTrue(course.getCourse_id()==1);
    }

    @Test
    public void setCourseNameTest(){
        courseModel course=new courseModel();
        course.setCourse_name("Software");
        assertTrue(course.getCourse_name()=="Software");
    }

    @Test
    public void setCourseCodeTest(){
        courseModel course=new courseModel();
        course.setCourse_code("CSCI-5308");
        assertTrue(course.getCourse_code()=="CSCI-5308");
    }

    @Test
    public void setTermTest(){
        courseModel course=new courseModel();
        course.setTerm("summer");
        assertTrue(course.getTerm()=="summer");
    }

    @Test
    public void setYearTest(){
        courseModel course=new courseModel();
        course.setYear(2020);
        assertTrue(course.getYear()==2020);
    }

}
