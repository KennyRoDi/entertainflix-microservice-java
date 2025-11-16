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

        // Explicitly load .env.local
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        // Expose the environment variables so Spring Boot sees them
        System.setProperty("SPRING_PROFILES_ACTIVE", dotenv.get("SPRING_PROFILES_ACTIVE"));
        System.setProperty("SPRING_DATASOURCE_URL", dotenv.get("SPRING_DATASOURCE_URL"));
        System.setProperty("SPRING_DATASOURCE_USERNAME", dotenv.get("SPRING_DATASOURCE_USERNAME"));
        System.setProperty("SPRING_DATASOURCE_PASSWORD", dotenv.get("SPRING_DATASOURCE_PASSWORD"));

        // Optional: Azure storage configs
        if (dotenv.get("AZURE_STORAGE_QUEUE_CONNECTION_STRING") != null) {
            System.setProperty("AZURE_STORAGE_QUEUE_CONNECTION_STRING",
                    dotenv.get("AZURE_STORAGE_QUEUE_CONNECTION_STRING"));
        }
        if (dotenv.get("AZURE_STORAGE_QUEUE_NAME") != null) {
            System.setProperty("AZURE_STORAGE_QUEUE_NAME",
                    dotenv.get("AZURE_STORAGE_QUEUE_NAME"));
        }

        SpringApplication.run(MicroserviceJavaApplication.class, args);
    }
}
