package sofaclient;

import com.alipay.sofa.rpc.context.RpcInvokeContext;
import com.example.service.HelloCallbackService;
import com.example.service.HelloSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RestController
@RequestMapping("/rpc")
public class Controller {

    @Autowired
    HelloCallbackService callbackService;

    @Autowired
    HelloSyncService syncService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping()
    String rpc() {
        RpcInvokeContext context = RpcInvokeContext.getContext();
        context.putRequestBaggage("user", "robbie");
        String rpcResult = this.syncService.say("robbie");
        System.out.println("get rpc resp : " + rpcResult);
        System.out.println("context resp : " + context.getResponseBaggage("user"));
        rabbitTemplate.convertAndSend("topicExchangeName-robbie", "foo.bar.baz", "Hello from RabbitMQ!");
        return rpcResult;
    }
}
