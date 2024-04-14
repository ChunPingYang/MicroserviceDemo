package com.chunping.springcloud.controller;

import com.chunping.springcloud.entities.CommonResult;
import com.chunping.springcloud.entities.Payment;
import com.chunping.springcloud.service.PaymentService;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

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
            return new CommonResult<>(200, "payment success, serverPort: "+serverPort, payment);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            log.info("*****element:" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t" + instance.getHost() +
                    "\t" + instance.getPort() +"\t" + instance.getUri());
        }

        return  this.discoveryClient;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            return serverPort;
        }
    }
}
