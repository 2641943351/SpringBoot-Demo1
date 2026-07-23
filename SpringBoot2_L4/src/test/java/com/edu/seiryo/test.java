package com.edu.seiryo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String password = "123456";

        String dbPassword = "$2a$10$Bl.B94Xj212z9b8KPEATYOCxUZmViFnSwmsLpBpZq8/05Tj09mNue";

        System.out.println(
            encoder.matches(password, dbPassword)
        );
    }
}