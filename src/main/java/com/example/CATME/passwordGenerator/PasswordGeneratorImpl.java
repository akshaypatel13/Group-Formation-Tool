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
        String numbers = "123456789";
        String symbols = "!@#$%^&*)";

        String values = upperCase + lowerCase +
                numbers + symbols;

        Random rndm_method = new Random();

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++)
        {
            password.append(values.charAt(rndm_method.nextInt(values.length())));
        }
        return password.toString();
    }
}
