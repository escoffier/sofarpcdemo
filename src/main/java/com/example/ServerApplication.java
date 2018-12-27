package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({ "classpath*:sofabean.xml" })
public class ServerApplication {

    public static void main(String[] args) {
        //SpringApplication.run(ServerApplication.class, args);
        SpringApplication springApplication = new SpringApplication(ServerApplication.class);
        ApplicationContext applicationContext = springApplication.run(args);
    }

}

