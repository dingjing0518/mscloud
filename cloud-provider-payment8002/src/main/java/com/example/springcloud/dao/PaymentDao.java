package com.example.springcloud.dao;

import com.example.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

import javax.websocket.server.PathParam;

@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getById(@PathParam("id") Long id);
}
