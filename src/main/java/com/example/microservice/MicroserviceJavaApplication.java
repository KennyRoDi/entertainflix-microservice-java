package com.example.microservice;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableAsync
@EnableMethodSecurity(prePostEnabled = true)
public class MicroserviceJavaApplication {

    public static void main(String[] args) {
        try {
            Dotenv dotenv = Dotenv.configure()
                    .ignoreIfMissing()
                    .load();

            // Only set if value exists
            setPropertyIfExists(dotenv, "SPRING_PROFILES_ACTIVE");
            setPropertyIfExists(dotenv, "SPRING_DATASOURCE_URL");
            setPropertyIfExists(dotenv, "SPRING_DATASOURCE_USERNAME");
            setPropertyIfExists(dotenv, "SPRING_DATASOURCE_PASSWORD");
            setPropertyIfExists(dotenv, "AZURE_STORAGE_QUEUE_CONNECTION_STRING");
            setPropertyIfExists(dotenv, "AZURE_STORAGE_QUEUE_NAME");
        } catch (Exception e) {
            // Silently ignore if .env doesn't exist (cloud environment)
        }

        SpringApplication.run(MicroserviceJavaApplication.class, args);
    }

    private static void setPropertyIfExists(Dotenv dotenv, String key) {
        String value = dotenv.get(key);
        if (value != null && !value.isEmpty()) {
            System.setProperty(key, value);
        }
    }
}