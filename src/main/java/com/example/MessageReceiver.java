package com.example;

//import com.alipay.sofa.rpc.log.Logger;
//import com.alipay.sofa.rpc.log.LoggerFactory;
import com.example.Model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class MessageReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageReceiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("MessageReceiver Received <" + message + ">");
        latch.countDown();
    }

//    @RabbitListener
    public void receiveMessage(Order message) {
        LOGGER.info("MessageReceiver Received <" + message + ">  -- " + Thread.currentThread().getName());
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
