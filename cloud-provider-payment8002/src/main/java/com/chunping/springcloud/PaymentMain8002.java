package com.chunping.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8002 {

    public static void main(String[] args){
        SpringApplication.run(PaymentMain8002.class, args);
    }
}
