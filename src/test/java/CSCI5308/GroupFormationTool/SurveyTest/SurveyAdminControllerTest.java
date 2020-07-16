package CSCI5308.GroupFormationTool.SurveyTest;

import CSCI5308.GroupFormationTool.Courses.Role;
import CSCI5308.GroupFormationTool.Survey.SurveyAdminController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sun.reflect.annotation.ExceptionProxy;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SurveyAdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private SurveyAdminController surveyAdminController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(surveyAdminController)
                .build();
    }

    @Test
    public void insertQuestionSurveyTest() throws Exception{
        this.mockMvc.perform(post("/survey/insertquestion").param("questionID","1")
                .param("courseID","22")
                .param("algo","test")
                .with(csrf())
                .with(
                        user("B-2232")
                                .password("1234")
                                .roles(Role.INSTRUCTOR.toString())
                ))
                .andDo(print());
    }

    @Test
    public void deleteSurveyQuestionTest() throws Exception{
        this.mockMvc.perform(post("/surveyQuestion/delete").param("questionID","1")
                .param("courseID","1")
                .with(csrf())
                .with(
                        user("B-000000")
                                .password("1234")
                                .roles(Role.INSTRUCTOR.toString())
                ))
                .andDo(print())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isFound());
    }

    @Test
    public void publishSurveyTest() throws Exception{
        this.mockMvc.perform(post("/survey/publish")
                .param("courseID","1")
                .param("groupSize","10")
                .with(csrf())
                .with(
                        user("B-000000")
                                .password("1234")
                                .roles(Role.INSTRUCTOR.toString())
                ))
                .andDo(print())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(redirectedUrl("/survey/survey?courseID=1"))
                .andExpect(status().isFound());
    }

    @Test
    public void disableSurveyTest() throws Exception{
        this.mockMvc.perform(get("/survey/disable")
                .param("courseID","1")
                .with(csrf())
                .with(
                        user("B-000000")
                                .password("1234")
                                .roles(Role.INSTRUCTOR.toString())
                ))
                .andDo(print())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(redirectedUrl("/survey/survey?courseID=1"))
                .andExpect(status().isFound());
    }



}
