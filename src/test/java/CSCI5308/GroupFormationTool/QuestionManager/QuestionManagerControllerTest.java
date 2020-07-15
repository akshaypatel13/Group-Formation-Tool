package CSCI5308.GroupFormationTool.QuestionManager;

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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class QuestionManagerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void questionsByTitleTest() throws Exception{
        this.mockMvc.perform(get("/question/questionmanager/title")
                .param("bannerID","B00854211")
                .with(csrf())
                .with(
                        user("B00854211")
                                .password("Abcd@11")
                                .roles(Role.INSTRUCTOR.toString())
                ))
                .andDo(MockMvcResultHandlers.print())
                .andDo(print())
                .andExpect(model().attributeExists("questionList"))
                .andExpect(status().isOk());
    }

    @Test
    public void questionsByDateTest() throws Exception{
        this.mockMvc.perform(get("/question/questionmanager/date")
                .param("bannerID","B00854211")
                .with(csrf())
                .with(
                        user("B00854211")
                                .password("Abcd@11")
                                .roles(Role.INSTRUCTOR.toString())
                ))
                .andDo(MockMvcResultHandlers.print())
                .andDo(print())
                .andExpect(model().attributeExists("questionList"))
                .andExpect(status().isOk());
    }


}
