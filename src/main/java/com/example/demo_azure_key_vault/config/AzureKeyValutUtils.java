//package com.example.demo_azure_key_vault.config;
//
//import com.azure.identity.DefaultAzureCredentialBuilder;
//import com.azure.security.keyvault.secrets.SecretClient;
//import com.azure.security.keyvault.secrets.SecretClientBuilder;
//import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.BeanInitializationException;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.PostConstruct;
//
//@Configuration
//public class AzureKeyValutUtils {
//    private static String SECURITY_KEY;
//
//    public static String getUSERNAME() {
//        return USERNAME;
//    }
//
//    public static String getPASSWORD() {
//        return PASSWORD;
//    }
//
//    private static String USERNAME;
//    private static String PASSWORD;
//
//    @PostConstruct
//    public void init() {
//        //初始化赋值
//
//        SecretClient secretClient = new SecretClientBuilder()
//                .vaultUrl("https://testkeyvalutname.vault.azure.net/")
//                .credential(new DefaultAzureCredentialBuilder().build())
//                .buildClient();
//
//        //新增
////        KeyVaultSecret username = secretClient.setSecret("username", "root");
////        KeyVaultSecret password = secretClient.setSecret("password", "123456");
//        USERNAME = secretClient.getSecret("username").getValue();
//        PASSWORD = secretClient.getSecret("password").getValue();
//        System.out.println("获取到账号密码为" + USERNAME + PASSWORD);
//        if (StringUtils.isEmpty(USERNAME) || StringUtils.isEmpty(PASSWORD)) {
//            throw new BeanInitializationException("未从key valut 获取数据库连接信息");
//        }
//        //新增
////        KeyVaultSecret secret = secretClient.setSecret("testname1", "testvalue1");
////        System.out.printf("Secret created with name \"%s\" and value \"%s\"%n", secret.getName(), secret.getValue());
//
//        //查询一个
//        KeyVaultSecret secret2 = secretClient.getSecret("testname1");
//        System.out.printf("根据name获取value \"%s\" and value \"%s\"%n", secret2.getName(), secret2.getValue());
//
////        //更新一个
////        secret2.getProperties().setExpiresOn(OffsetDateTime.now().plusDays(30));
////        SecretProperties updatedSecretProperties = secretClient.updateSecretProperties(secret2.getProperties());
////        System.out.printf("Secret's updated expiry time: %s%n", updatedSecretProperties.getExpiresOn());
////
////        //查询列表
////        for (SecretProperties secretProperties : secretClient.listPropertiesOfSecrets()) {
////            KeyVaultSecret secretWithValue = secretClient.getSecret(secretProperties.getName(), secretProperties.getVersion());
////            System.out.printf("根据name获取value \"%s\" and value \"%s\"%n", secretWithValue.getName(),
////                    secretWithValue.getValue());
////        }
//
//        System.out.println(secretClient.toString());
//        SECURITY_KEY = secret2.getValue();
//    }
//
//    public static String getEntozhOfString() {
//        //静态方法使用静态变量
//        System.out.println(SECURITY_KEY);
//        return SECURITY_KEY;
//    }
//}
