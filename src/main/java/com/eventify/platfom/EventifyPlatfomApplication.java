package com.eventify.platfom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EventifyPlatfomApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventifyPlatfomApplication.class, args);
    }

}
