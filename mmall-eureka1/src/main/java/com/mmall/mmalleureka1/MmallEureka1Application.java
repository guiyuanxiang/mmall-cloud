package com.mmall.mmalleureka1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MmallEureka1Application {

    public static void main(String[] args) {
        SpringApplication.run(MmallEureka1Application.class, args);
    }
}