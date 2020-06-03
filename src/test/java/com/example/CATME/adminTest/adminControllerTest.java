package com.example.CATME.adminTest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class adminControllerTest {

	@Autowired
	MockMvc mock;
	
	@Test
	public void admintest() throws Exception{
		this.mock.perform(get("/admin").with(user("abcd@122").password("aksbja").roles("ADMIN"))).andExpect(status().isOk()).andExpect(model().attributeExists("courses"));
	}

	@Test
	public void deleteCourseTest() throws Exception{

		this.mock.perform(post("/deleteCourse").param("course_id","cdddd"));
	}

	@Test
	public void addInstructorTest() throws Exception{
		this.mock.perform(post("/addInstructor").param("course_id","cdddd"));

	}

	@Test
	public void insertInstTest() throws Exception{
		this.mock.perform(post("/insertInst").param("course_id","").param("username",""));

	}

	@Test
	public void insertCourse() throws Exception{
		this.mock.perform(post("/insertCourse").param("course_name","cdddd").param("term","jdch").param("year","123").param("course_code","cdddd"));

	}






}
