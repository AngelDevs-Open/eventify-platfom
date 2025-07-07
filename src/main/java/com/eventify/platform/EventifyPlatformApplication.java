package com.eventify.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EventifyPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventifyPlatformApplication.class, args);
    }

}
