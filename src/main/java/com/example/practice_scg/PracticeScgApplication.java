package com.example.practice_scg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PracticeScgApplication {
    public static void main(String[] args) {
        SpringApplication.run(PracticeScgApplication.class, args);
    }

}
