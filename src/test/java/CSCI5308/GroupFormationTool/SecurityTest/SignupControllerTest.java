package CSCI5308.GroupFormationTool.SecurityTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SignupControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void displaySignupTest() throws Exception {
		this.mockMvc.perform(get("/signup")).andExpect(status().isOk());
	}

}
