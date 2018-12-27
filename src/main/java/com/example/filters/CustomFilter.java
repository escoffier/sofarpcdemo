package com.example.filters;

import com.alipay.sofa.rpc.core.exception.SofaRpcException;
import com.alipay.sofa.rpc.core.request.SofaRequest;
import com.alipay.sofa.rpc.core.response.SofaResponse;
import com.alipay.sofa.rpc.ext.Extension;
import com.alipay.sofa.rpc.filter.AutoActive;
import com.alipay.sofa.rpc.filter.Filter;
import com.alipay.sofa.rpc.filter.FilterInvoker;
import com.alipay.sofa.rpc.log.Logger;
import com.alipay.sofa.rpc.log.LoggerFactory;

@Extension("customer")
@AutoActive(providerSide = true, consumerSide = true)
public class CustomFilter extends Filter {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public SofaResponse invoke(FilterInvoker invoker, SofaRequest request) throws SofaRpcException {

        LOGGER.info("CustomFilter invoked");
        System.out.println("CustomFilter invoked");
        SofaResponse response = invoker.invoke(request);
        return response;
    }

    @Override
    public boolean needToLoad(FilterInvoker invoker) {
        //return super.needToLoad(invoker);
        return true;
    }
}
