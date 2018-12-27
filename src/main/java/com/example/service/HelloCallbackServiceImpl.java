package com.example.service;

public class HelloCallbackServiceImpl implements HelloCallbackService {
    @Override
    public String sayCallback(String string) {

        String result = new String("Callback Hello " + string + " [" + Thread.currentThread().getName() + "]");
        System.out.println(result);
        return result;
    }
}
