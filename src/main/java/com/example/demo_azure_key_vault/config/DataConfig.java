package com.example.demo_azure_key_vault.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataConfig {

    private String driver;
    private String url;
    private String username;
    private String password;

    @Bean
    public DataSource dataSource() {
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.url = "jdbc:mysql://127.0.0.1:3306/test";
        this.username = AzureKeyValutUtils.getUSERNAME();
        this.password = AzureKeyValutUtils.getPASSWORD();
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

