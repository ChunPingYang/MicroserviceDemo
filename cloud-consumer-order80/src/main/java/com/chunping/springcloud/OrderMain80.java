package com.chunping.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//https://www.cnblogs.com/javastack/p/12016212.html
//@EnableAutoConfiguration
//(exclude = {DataSourceAutoConfiguration.class, MailSenderAutoConfiguration.class})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class OrderMain80 {

    public static void main(String[] args){
        SpringApplication.run(OrderMain80.class, args);
    }
}
