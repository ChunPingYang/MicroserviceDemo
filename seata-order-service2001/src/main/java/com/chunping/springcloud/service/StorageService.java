package com.chunping.springcloud.service;


import entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Component
//@FeignClient(value = "SEATA-STORAGE-SERVICE")
public interface StorageService {

//    @PostMapping(value = "/storage/decrease")
//    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
