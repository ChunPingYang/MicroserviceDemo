package com.chunping.springcloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class SendMessageController {

    @Autowired
    StreamBridge streamBridge;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        String serial = UUID.randomUUID().toString();
        streamBridge.send("demoChannel-out-0", MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: "  +serial);
        return "success";
    }
}
