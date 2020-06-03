package com.example.CATME.adminTest;

import com.example.CATME.admin.userModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertTrue;

@SpringBootTest
public class userModelTest {

    @Test
    public void setUsernameTest(){
        userModel user=new userModel();
        user.setUsername("akshay@dal.ca");
        assertTrue(user.getUsername()=="akshay@dal.ca");
    }

    @Test
    public void setFirstNameTest(){
        userModel user=new userModel();
        user.setFirst_name("Akshay");
        assertTrue(user.getFirst_name()=="Akshay");
    }

    @Test
    public void setLastNameTest(){
        userModel user=new userModel();
        user.setLast_name("Patel");
        assertTrue(user.getLast_name()=="Patel");
    }

    @Test
    public void setBannerIDTest(){
        userModel user=new userModel();
        user.setBanner_id("B00854211");
        assertTrue(user.getBanner_id()=="B00854211");
    }

    @Test
    public void setPasswordTest(){
        userModel user=new userModel();
        user.setPassword("akshay@123");
        assertTrue(user.getPassword()=="akshay@123");
    }

    @Test
    public void setEnabledTest(){
        userModel user=new userModel();
        user.setEnabled(1);
        assertTrue(user.getEnabled()==1);
    }

    @Test
    public void setUSerId(){
        userModel user=new userModel();
        user.setUser_id("abcd12");
        assertTrue(user.getUser_id()=="abcd12");
    }

}
