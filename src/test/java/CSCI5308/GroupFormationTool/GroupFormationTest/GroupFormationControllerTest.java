package CSCI5308.GroupFormationTool.GroupFormationTest;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import CSCI5308.GroupFormationTool.Courses.Role;

@SpringBootTest
@AutoConfigureMockMvc
public class GroupFormationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void loadGroupsTest() throws Exception {
		this.mockMvc
				.perform(get("/formgroups")
				.param("courseID", "121")
				.with(csrf())
				.with(user("B-009911")
				.password("Abcd@11")
				.roles(Role.INSTRUCTOR.toString())))
				.andDo(MockMvcResultHandlers.print())
                .andDo(print())
                .andExpect(status().isOk());
	}
	 

}
