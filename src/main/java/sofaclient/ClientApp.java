package sofaclient;

//import com.example.service.HelloCallbackService;
//import com.example.service.HelloSyncService;
//import com.example.sofaserver.ServerApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:sofaclientbean.xml")
@ComponentScan(basePackages = {"com.example.filters", "sofaclient"})
public class ClientApp {

    public static void main(String[] args) {

        System.setProperty("server.port", "9081");

        //SpringApplication.run(ServerApplication.class, args);

        SpringApplication springApplication = new SpringApplication(ClientApp.class);
        ApplicationContext applicationContext = springApplication.run(args);

//        HelloSyncService helloSyncService = (HelloSyncService)applicationContext.getBean("helloServiceReference");
//
//        HelloCallbackService helloCallbackService = (HelloCallbackService)applicationContext.getBean("helloCallbackServiceReference");
//
//        for (int i = 0; i < 20; ++i){
//            String result = helloSyncService.say("robbie");
//            System.out.println("invoke result:" + result);
//        }
//
//        for (int i = 0; i < 20; ++i){
//            String result = helloCallbackService.sayCallback("escoffier");
//            //System.out.println("invoke result:" + result);
//        }



    }
}
