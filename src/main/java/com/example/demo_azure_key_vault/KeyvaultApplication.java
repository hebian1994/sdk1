package com.example.demo_azure_key_vault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.annotation.PostConstruct;

@SpringBootApplication
public class KeyvaultApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeyvaultApplication.class, args);
    }

    @PostConstruct
    public void test() {
        String property = "aaa.bbb";
        System.out.println("test1" + property);
    }
}
