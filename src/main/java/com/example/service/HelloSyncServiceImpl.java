package com.example.service;

import com.alipay.sofa.rpc.context.RpcInvokeContext;

public class HelloSyncServiceImpl implements HelloSyncService {
    public String say(String str) {
        RpcInvokeContext context = RpcInvokeContext.getContext();
        System.out.println("context : " + context.getRequestBaggage("user"));

        context.putResponseBaggage("user", "new robbie");

        return "Hello " + str + " [" + Thread.currentThread().getName() + "]";
    }

}
