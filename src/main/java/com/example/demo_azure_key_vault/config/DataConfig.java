package com.example.demo_azure_key_vault.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
public class DataConfig {

    private static SecretClient secretClient;

    public static SecretClient getSecretClient() {
        return secretClient;
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    private static String USERNAME;
    private static String PASSWORD;

    @PostConstruct
    public void init() {
        //初始化赋值

        secretClient = new SecretClientBuilder()
                .vaultUrl("https://testkeyvalutname.vault.azure.net/")
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();

        //新增
//        KeyVaultSecret username = secretClient.setSecret("username", "root");
//        KeyVaultSecret password = secretClient.setSecret("password", "123456");
        USERNAME = secretClient.getSecret("username").getValue();
        PASSWORD = secretClient.getSecret("password").getValue();
        System.out.println("获取到账号密码为" + USERNAME + PASSWORD);
        if (StringUtils.isEmpty(USERNAME) || StringUtils.isEmpty(PASSWORD)) {
            throw new BeanInitializationException("未从key valut 获取数据库连接信息");
        }
        //新增
//        KeyVaultSecret secret = secretClient.setSecret("testname1", "testvalue1");
//        System.out.printf("Secret created with name \"%s\" and value \"%s\"%n", secret.getName(), secret.getValue());

        //查询一个
        KeyVaultSecret secret2 = secretClient.getSecret("testname1");
        System.out.printf("根据name获取value \"%s\" and value \"%s\"%n", secret2.getName(), secret2.getValue());

//        //更新一个
//        secret2.getProperties().setExpiresOn(OffsetDateTime.now().plusDays(30));
//        SecretProperties updatedSecretProperties = secretClient.updateSecretProperties(secret2.getProperties());
//        System.out.printf("Secret's updated expiry time: %s%n", updatedSecretProperties.getExpiresOn());
//
//        //查询列表
//        for (SecretProperties secretProperties : secretClient.listPropertiesOfSecrets()) {
//            KeyVaultSecret secretWithValue = secretClient.getSecret(secretProperties.getName(), secretProperties.getVersion());
//            System.out.printf("根据name获取value \"%s\" and value \"%s\"%n", secretWithValue.getName(),
//                    secretWithValue.getValue());
//        }
    }


    private String driver;
    private String url;
    private String username;
    private String password;

    @Bean
    public DataSource dataSource() {
        this.driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        this.url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=bom_accounting;integratedSecurity=false;encrypt=false;trustServerCertificate=false";
        this.username = DataConfig.getUSERNAME();
        this.password = DataConfig.getPASSWORD();
//        this.username = "sa";
//        this.password = "123456";
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(true);
        return dataSource;
    }

}

