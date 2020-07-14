package CSCI5308.GroupFormationTool.SecurityTest;

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SignupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void displaySignupTest() throws Exception{
        this.mockMvc.perform(get("/signup"))
        .andExpect(status().isOk());
    }

    @Test
    public void processSignupTest() throws Exception{
        this.mockMvc.perform(post("/signup")
                .param("username","B00854211")
                .param("password","Abcd@123")
                .param("passwordConfirmation","Abcd@123")
                .param("firstName","Akshay")
                .param("lastName","Patel")
                .param("email","ak811226@dal.ca")
                .with(csrf())
                .with(
                        user("B00854211")
                                .password("Abcd@123")
                                .roles(Role.INSTRUCTOR.toString())
                ))
                .andDo(MockMvcResultHandlers.print())
                .andDo(print())
                .andExpect(status().isOk());
    }



}
