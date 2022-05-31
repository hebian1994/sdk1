package com.example.demo_azure_key_vault.controller;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import com.azure.security.keyvault.secrets.models.SecretProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

/**
 * https://azuresdkdocs.blob.core.windows.net/$web/java/azure-security-keyvault-secrets/4.4.2/index.html
 * 此时要在edit configuration中写上environment variables属性
 * AZURE_CLIENT_ID=5d573d48-e1d2-4ec8-bf40-8fcdf7e50377;
 * AZURE_CLIENT_SECRET=XVn8Q~5BnbZ0~Qsa3KJW0mKxoBpRVIAtPyPCBbre;
 * AZURE_TENANT_ID=9c6f33c6-0a22-45e9-b129-78843f81e5f8
 */
@RestController
public class TestController2 {

    @GetMapping("get")
    public void get() {

    }
}
