package com.example.CATME.instructor;

import com.example.CATME.signup.User;
import com.example.CATME.signup.UserService;

public class UserServiceMock implements UserService {
    @Override
    public void register(User user) {
        user.setFirstname("Tom");
        user.setLastname("Johnson");
        user.setBannerId("B1111111");
        user.setEmail("abc@dal.ca");
    }
}
