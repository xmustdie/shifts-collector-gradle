package com.goodt.shiftscollectorgradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ShiftsCollectorGradleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiftsCollectorGradleApplication.class, args);
    }

}
