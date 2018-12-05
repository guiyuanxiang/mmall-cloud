package com.mmall.mmallorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author nobody
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MmallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmallOrderApplication.class, args);
    }
}
