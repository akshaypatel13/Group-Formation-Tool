package CSCI5308.GroupFormationTool.CoursesTest;

import CSCI5308.GroupFormationTool.Courses.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class InstructorAdminControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void instructorAdminTest() throws Exception {
		this.mockMvc
				.perform(get("/course/instructoradmin").param("id", "121").with(csrf())
						.with(user("B-009911").password("Abcd@11").roles(Role.INSTRUCTOR.toString())))
				.andDo(MockMvcResultHandlers.print()).andDo(print())
				.andExpect(model().attributeExists("course", "displayresults")).andExpect(status().isOk());
	}

	@Test
	public void instructorAdminResultsTest() throws Exception {
		this.mockMvc
				.perform(get("/course/instructoradminresults").param("id", "121").param("displayresults", "true")
						.with(csrf()).with(user("B-009911").password("Abcd@11").roles(Role.INSTRUCTOR.toString())))
				.andDo(MockMvcResultHandlers.print()).andDo(print())
				.andExpect(model().attributeExists("course", "displayresults")).andExpect(status().isOk());
	}

	@Test
	public void enrollTA() throws Exception {
		this.mockMvc
				.perform(get("/course/enrollta").param("id", "121").param("displayresults", "true").with(csrf())
						.with(user("B-009911").password("Abcd@11").roles(Role.INSTRUCTOR.toString())
								.roles(Role.TA.toString())))
				.andDo(MockMvcResultHandlers.print()).andDo(print()).andExpect(status().isOk());
	}

}
