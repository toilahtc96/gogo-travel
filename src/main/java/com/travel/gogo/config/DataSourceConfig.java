//package com.travel.gogo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.vault.annotation.VaultPropertySource;
//
//import javax.sql.DataSource;
//
//@Configuration
//@VaultPropertySource("secret/gogo")
//public class DataSourceConfig {
//    @Autowired
//    Environment env;
//    @Bean
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
//        dataSourceBuilder.url("jdbc:mysql://gogo-database.c5uaceqami1p.ap-south-1.rds.amazonaws.com:3306/gogo_travel");
//        dataSourceBuilder.username(env.getProperty("usernamedb"));
//        dataSourceBuilder.password(env.getProperty("password"));
//        return dataSourceBuilder.build();
//    }
//}
