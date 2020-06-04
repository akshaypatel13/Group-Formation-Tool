package com.example.CATME.adminTest;

import com.example.CATME.admin.*;
import com.example.CATME.admin.authoritiesModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertTrue;

@SpringBootTest
public class authoritiesModelTest {

    @Test
    public void setUserNameTest(){
        authoritiesModel auth=new authoritiesModel();
        auth.setUsername("akshay@dal.ca");
        assertTrue(auth.getUsername()=="akshay@dal.ca");
    }

    @Test
    public void setCourseIdTest(){
        authoritiesModel auth=new authoritiesModel();
        auth.setCourse_id(1);
        assertTrue(auth.getCourse_id()==1);
    }

    @Test
    public void setAuthorityTest(){
        authoritiesModel auth=new authoritiesModel();
        auth.setAuthority("ROLE_INSTRUCTOR");
        assertTrue(auth.getAuthority()=="ROLE_INSTRUCTOR");
    }

    @Test
    public void setAuthIdTest(){
        authoritiesModel auth=new authoritiesModel();
        auth.setAuth_id("abcd123");
        assertTrue(auth.getAuth_id()=="abcd123");
    }
}
