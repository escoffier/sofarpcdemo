package com.example.config;

import com.example.Model.Order;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
//@RabbitListener(queues = "closeOrder2")
public class MessageListener {


    //@RabbitHandler
    public void receiveMessage(Order message) {
        System.out.println("Received <" + message + ">--thread: " + Thread.currentThread().getName());
    }
}
