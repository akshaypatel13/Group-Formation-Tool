package CSCI5308.GroupFormationTool.QuestionManager;

import CSCI5308.GroupFormationTool.Courses.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class QuestionAdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deleteQuestionTest() throws Exception{
        this.mockMvc.perform(post("/question/delete")
                .param("id","121")
                .param("bannerID","B00854211")
                .with(csrf())
                .with(
                        user("B-009911")
                                .password("Abcd@11")
                                .roles(Role.INSTRUCTOR.toString())
                ))
                .andDo(MockMvcResultHandlers.print())
                .andDo(print())
                .andExpect(redirectedUrl("/question/questionmanager/title?bannerID=B00854211"))
                .andExpect(status().isFound());
    }

    @Test
    public void addQuestionTest() throws Exception{
        this.mockMvc.perform(post("/question/add")
                .param("id","121")
                .param("bannerID","B00854211")
                .with(csrf())
                .with(
                        user("B-009911")
                                .password("Abcd@11")
                                .roles(Role.INSTRUCTOR.toString())
                ))
                .andDo(MockMvcResultHandlers.print())
                .andDo(print())
                .andExpect(model().attributeExists("question","questionTypes"))
                .andExpect(status().isOk());
    }

}
