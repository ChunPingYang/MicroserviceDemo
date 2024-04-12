package com.chunping.springcloud.service;

import com.chunping.springcloud.entities.Payment;
import com.chunping.springcloud.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public Payment create(Payment payment){
        return paymentRepository.save(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentRepository.findById(id).get();
    }
}
