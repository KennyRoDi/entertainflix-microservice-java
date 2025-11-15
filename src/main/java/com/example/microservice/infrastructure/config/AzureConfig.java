package com.example.microservice.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;

@Configuration
public class AzureConfig {

    @Value("${azure.ad.tenant-id:}")
    private String tenantId;

    @Value("${azure.ad.client-id:}")
    private String clientId;

    @Value("${azure.ad.client-secret:}")
    private String clientSecret;

    @Bean
    @Profile("!local")
    public ClientSecretCredential azureCredential() {
        if (clientSecret != null && !clientSecret.isEmpty() &&
                tenantId != null && !tenantId.isEmpty() &&
                clientId != null && !clientId.isEmpty()) {
            return new ClientSecretCredentialBuilder()
                    .tenantId(tenantId)
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .build();
        }
        // Fallback to DefaultAzureCredential (managed identity)
        return null;
    }

    @Bean
    @Profile("local")
    public DefaultAzureCredential defaultAzureCredentialLocal() {
        return new DefaultAzureCredentialBuilder().build();
    }
}