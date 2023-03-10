package com.javatechie.controller;

import com.javatechie.dto.PaymentRequest;
import com.javatechie.publisher.PaytmPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaytmController {

    @Autowired
    private PaytmPublisher publisher;

    @PostMapping("/mq/pay")
    public String payUsingUPI(@RequestBody PaymentRequest request) {
        publisher.doPaymentTransaction(request);
        return "payment request in process !!";
    }
}
