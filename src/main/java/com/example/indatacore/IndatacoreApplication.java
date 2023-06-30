package com.example.indatacore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//  Swagger UI adds a set of resources which you must configure as part of a class that extends WebMvcConfigurerAdapter,
//  and is annotated with @EnableWebMvc.
@EnableWebMvc
@SpringBootApplication
public class IndatacoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(IndatacoreApplication.class, args);
    }

}
