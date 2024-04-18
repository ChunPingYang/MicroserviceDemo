package com.chunping.springcloud.service.impl;

import com.chunping.springcloud.domain.Order;
import com.chunping.springcloud.repository.OrderRepository;
import com.chunping.springcloud.service.AccountService;
import com.chunping.springcloud.service.OrderService;
import com.chunping.springcloud.service.StorageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Resource
    StorageService storageService;
    @Resource
    AccountService accountService;

    @Override
    public void create(Order order) {
        log.info("------開始新建訂單");

    }
}
