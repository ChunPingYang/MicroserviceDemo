package com.chunping.springcloud.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class ReceiveMessageListener {

    @Value("${server.port}")
    String serverPort;

    @Bean
    public Consumer<String> demoChannel(){ //與配置檔裡的demoChannel-in-0配對
//        return new Consumer<String>() {
//
//            @Override
//            public void accept(String s) {
//                log.info("demoChannel:{}", s);
//            }
//        };
        return msg -> log.info("demoChannel接到消息：{} ,serverPort: {}", msg, serverPort);
    }
}
