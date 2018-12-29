package com.example.service;

import com.alipay.sofa.rpc.context.RpcInvokeContext;
import com.example.filters.CustomFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloSyncServiceImpl implements HelloSyncService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomFilter.class);

    public String say(String str) {
        RpcInvokeContext context = RpcInvokeContext.getContext();
        LOGGER.info("context : " + context.getRequestBaggage("user"));
        context.putResponseBaggage("user", "new robbie");

        return "Hello " + str + " [" + Thread.currentThread().getName() + "]";
    }

}
