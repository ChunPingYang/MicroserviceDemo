package com.chunping.springcloud.controller;

import com.chunping.springcloud.entities.CommonResult;
import com.chunping.springcloud.entities.Payment;
import com.chunping.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping(value ="/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){

        Payment result = paymentService.create(payment);
        log.info("payment:{}",result);

        if(result != null){
            return new CommonResult<>(200, "insert payment data success", result);
        }else{
            return new CommonResult<>(444, "insert payment data fail");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> queryPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);
        log.info("payment:{}", payment);

        if(payment==null){
            return new CommonResult<>(444, "payment not found");
        }else{
            return new CommonResult<>(200, "payment success", payment);
        }
    }
}
