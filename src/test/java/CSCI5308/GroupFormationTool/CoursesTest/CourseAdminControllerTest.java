package CSCI5308.GroupFormationTool.CoursesTest;

import CSCI5308.GroupFormationTool.Courses.ICoursePersistence;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CourseAdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void courseTest() throws Exception {
        this.mockMvc.perform(get("/admin/course"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("courses"));

    }

    @Test
    public void assignInstructorTest() throws Exception {
        this.mockMvc.perform(get("/admin/course")
                .param("id","1")
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteCourseTest() throws Exception {
        this.mockMvc.perform(get("/admin/deletecourse")
                .param("id","121")
                .with(csrf())
                .with(
                        user("B-000000")
                                .password("1234")
                                .roles(Role.ADMIN.toString())
                ))
                .andDo(MockMvcResultHandlers.print())
                .andDo(print())
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/admin/course"));
    }

    @Test
    public void createCourseTest() throws Exception {
        this.mockMvc.perform(post("/admin/createcourse")
                .param("title","Abcd")
                .with(csrf())
                .with(
                        user("B-000000")
                        .password("1234")
                        .roles(Role.ADMIN.toString())
                )
        )
                .andDo(MockMvcResultHandlers.print())
                .andDo(print())
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/admin/course"));

    }

    @Test
    public void assignInstructorToCourseTest() throws Exception {
        this.mockMvc.perform(post("/admin/assigninstructor")
                .param("instructor","1")
                .param("id","1")
                .with(csrf())
                .with(
                        user("B-000000")
                                .password("1234")
                                .roles(Role.ADMIN.toString())
                )
        )
                .andDo(MockMvcResultHandlers.print())
                .andDo(print())
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/admin/course"));
    }

}
