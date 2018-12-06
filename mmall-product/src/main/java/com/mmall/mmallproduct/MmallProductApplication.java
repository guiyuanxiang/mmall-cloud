package com.mmall.mmallproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MmallProductApplication {

    public static void main(String[] args) {
        //todo sql优化
        SpringApplication.run(MmallProductApplication.class, args);
    }
}
