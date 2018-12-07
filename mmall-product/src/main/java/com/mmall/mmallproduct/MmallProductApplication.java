package com.mmall.mmallproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableDiscoveryClient
@ServletComponentScan
@ImportResource(locations = {"classpath:druid-bean.xml"})
public class MmallProductApplication {

    public static void main(String[] args) {
        //todo sql优化
        SpringApplication.run(MmallProductApplication.class, args);
    }
}
