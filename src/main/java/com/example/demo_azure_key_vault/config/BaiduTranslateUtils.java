package com.example.demo_azure_key_vault.config;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import com.azure.security.keyvault.secrets.models.SecretProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.OffsetDateTime;

@Component
public class BaiduTranslateUtils {
    private static String SECURITY_KEY;

    @PostConstruct
    public void init() {
        //初始化赋值

        SecretClient secretClient = new SecretClientBuilder()
                .vaultUrl("https://testkeyvalutname.vault.azure.net/")
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();

        //新增
//        KeyVaultSecret secret = secretClient.setSecret("testname1", "testvalue1");
//        System.out.printf("Secret created with name \"%s\" and value \"%s\"%n", secret.getName(), secret.getValue());

        //查询一个
        KeyVaultSecret secret2 = secretClient.getSecret("testname1");
        System.out.printf("根据name获取value \"%s\" and value \"%s\"%n", secret2.getName(), secret2.getValue());

        //更新一个
        secret2.getProperties().setExpiresOn(OffsetDateTime.now().plusDays(30));
        SecretProperties updatedSecretProperties = secretClient.updateSecretProperties(secret2.getProperties());
        System.out.printf("Secret's updated expiry time: %s%n", updatedSecretProperties.getExpiresOn());

        //查询列表
        for (SecretProperties secretProperties : secretClient.listPropertiesOfSecrets()) {
            KeyVaultSecret secretWithValue = secretClient.getSecret(secretProperties.getName(), secretProperties.getVersion());
            System.out.printf("根据name获取value \"%s\" and value \"%s\"%n", secretWithValue.getName(),
                    secretWithValue.getValue());
        }

        System.out.println(secretClient.toString());
        SECURITY_KEY = secret2.getValue();
    }

    public static String getEntozhOfString() {
        //静态方法使用静态变量
        System.out.println(SECURITY_KEY);
        return SECURITY_KEY;
    }
}
