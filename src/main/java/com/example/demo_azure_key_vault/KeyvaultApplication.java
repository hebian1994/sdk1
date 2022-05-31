package com.example.demo_azure_key_vault;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import com.azure.security.keyvault.secrets.models.SecretProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.OffsetDateTime;

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
