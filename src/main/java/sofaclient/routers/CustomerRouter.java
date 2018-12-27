package sofaclient.routers;

import com.alipay.sofa.rpc.bootstrap.ConsumerBootstrap;
import com.alipay.sofa.rpc.client.ProviderInfo;
import com.alipay.sofa.rpc.client.Router;
import com.alipay.sofa.rpc.core.request.SofaRequest;
import com.alipay.sofa.rpc.ext.Extension;
import com.alipay.sofa.rpc.filter.AutoActive;

import java.util.List;

@Extension("customerRouter")
@AutoActive(consumerSide = true)
public class CustomerRouter extends Router {
    @Override
    public List<ProviderInfo> route(SofaRequest request, List<ProviderInfo> providerInfos) {

        for (ProviderInfo providerInfo : providerInfos){
            System.out.println("ProviderInfo: " + providerInfo.toString());
        }
        return providerInfos;
    }

    @Override
    public boolean needToLoad(ConsumerBootstrap consumerBootstrap) {
        //return super.needToLoad(consumerBootstrap);
        return true;
    }

    @Override
    public void init(ConsumerBootstrap consumerBootstrap) {
        super.init(consumerBootstrap);
    }
}
