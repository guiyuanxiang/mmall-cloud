package com.mmall.mmalleureka2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MmallEureka2Application {

    public static void main(String[] args) {
        SpringApplication.run(MmallEureka2Application.class, args);
    }
}
