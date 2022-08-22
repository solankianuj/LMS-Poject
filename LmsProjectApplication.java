package com.bridgelabz.lmsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories("com.bridgelabz.lmsproject.repository")
public class LmsProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(LmsProjectApplication.class, args);
    }

}
