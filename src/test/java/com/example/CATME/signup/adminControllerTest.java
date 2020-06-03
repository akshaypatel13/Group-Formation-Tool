package com.example.CATME.signup;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.AutoConfigureDataJdbc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

@SpringBootTest
@AutoConfigureMockMvc
public class adminControllerTest {
	@Autowired
	MockMvc mock;
	
	@Test
	public void admintest() throws Exception{
		this.mock.perform(get("/admin")).andExpect(status().isOk()).andExpect(model().attributeExists("courses")).andExpect(status().isOk());
	}

	@Test
	public void deleteCourseTest() throws Exception{

		this.mock.perform(post("/deleteCourse").param("course_id","cdddd")).andExpect(model().attributeExists("status","courses"));
	}

	@Test
	public void addInstructorTest() throws Exception{
		this.mock.perform(post("/addInstructor").param("course_id","cdddd")).andExpect(model().attributeExists("users","course_id"));

	}

	/////
	@Test
	public void insertInstTest() throws Exception{
		this.mock.perform(post("/insertInst").param("course_id","").param("username","")).andExpect(status().isOk()).andExpect(model().attributeExists("status","courses"));

	}

	@Test
	public void insertCourse() throws Exception{
		this.mock.perform(post("/insertCourse").param("course_name","cdddd").param("term","jdch").param("year","123").param("course_code","cdddd")).andExpect(redirectedUrl("admin"));

	}






}
