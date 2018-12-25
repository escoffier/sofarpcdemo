package com.example.sofaserver;

public class HelloCallbackServiceImpl implements HelloCallbackService {
    @Override
    public String sayCallback(String string) {
        return "Callback Hello " + string + " [" + Thread.currentThread().getName() + "]";
    }
}
