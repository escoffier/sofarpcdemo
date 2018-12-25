package com.example.sofaserver;

public class HelloSyncServiceImpl implements HelloSyncService {
    @Override
    public String say(String str) {
        return "Hello " + str + " [" + Thread.currentThread().getName() + "]";
    }

}
