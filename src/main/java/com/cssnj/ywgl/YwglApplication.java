package com.cssnj.ywgl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAsync
@EnableTransactionManagement
@EnableConfigurationProperties
@SpringBootApplication
public class YwglApplication {

    public static void main(String[] args) {
        SpringApplication.run(YwglApplication.class, args);
    }

}
