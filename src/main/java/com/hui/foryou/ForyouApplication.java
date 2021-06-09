package com.hui.foryou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author HUI
 */
@SpringBootApplication
@EnableScheduling
public class ForyouApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForyouApplication.class, args);
    }

}
