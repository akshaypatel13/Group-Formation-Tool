package com.example.CATME.passwordGenerator;

import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class PasswordGeneratorImpl implements PasswordGenerator{

    @Override
    public String generatePassword() {

        int length = 10;
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";

        String values = upperCase + lowerCase +
                numbers + symbols;

        // Using random method
        Random rndm_method = new Random();

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            password.append(values.charAt(rndm_method.nextInt(values.length())));

        }
        return password.toString();
    }
}
