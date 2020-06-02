package com.example.CATME.passwordGenerator;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class passwordGeneratorImplTest {

    private final PasswordGenerator passwordGenerator = new PasswordGeneratorImpl();
    @Test
    public void generatePasswordTest(){
        String password = passwordGenerator.generatePassword();
        assertNotNull(password);
        assertEquals(password.length(), 10);
    }
}
