package com.example.springcloud.service;

import com.example.springcloud.entities.Payment;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getById(Long id);
}
