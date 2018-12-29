package com.example.config;

import com.example.MessageReceiver;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.DirectMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableRabbit
public class RabbitConfig {

    public static final String delayExchangeName = "delay.exchange1";
    public static final String timeOutOrderQueue = "closeOrder2";

    @Bean
    Queue delayQueue() {
        return new Queue(timeOutOrderQueue, true);
    }

    @Bean
    FanoutExchange exchange() {
        //return new TopicExchange(delayExchangeName);
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("x-delayed-type", "direct");
        FanoutExchange fanoutExchange = new FanoutExchange(delayExchangeName, true, false, args );
        fanoutExchange.setDelayed(true);
        return fanoutExchange;
    }

    @Bean
    Binding binding(Queue queue, FanoutExchange fanoutExchange) {
        //return BindingBuilder.bind(queue).to(topicExchange).with("foo.bar.#");
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

//    @Bean
//    //SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(timeOutOrderQueue);
//        //container.setMessageListener(listenerAdapter);
//        container.setConcurrentConsumers(3);
//        container.setMessageConverter(new Jackson2JsonMessageConverter());
//        return container;
//    }
//
//
//    @Bean
//    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setMessageConverter(new Jackson2JsonMessageConverter());
//        return factory;
//    }


//    @Bean
//    SimpleMessageListenerContainer containerWithAdapter(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(timeOutOrderQueue);
//        container.setMessageListener(listenerAdapter);
//        container.setConcurrentConsumers(3);
//        //container.setTaskExecutor();
//        //container.setMessageConverter(new Jackson2JsonMessageConverter());
//        return container;
//    }

    @Bean
        DirectMessageListenerContainer directContainer(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        DirectMessageListenerContainer directMessageListenerContainer = new DirectMessageListenerContainer();
        directMessageListenerContainer.setConnectionFactory(connectionFactory);
        directMessageListenerContainer.setQueueNames(timeOutOrderQueue);
        directMessageListenerContainer.setMessageListener(listenerAdapter);
        directMessageListenerContainer.setConsumersPerQueue(3);
        return directMessageListenerContainer;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(MessageReceiver receiver){
        MessageListenerAdapter adapter = new MessageListenerAdapter(receiver);
        adapter.setMessageConverter(new Jackson2JsonMessageConverter());
        adapter.setDefaultListenerMethod("receiveMessage");
        return adapter;
    }

//    @Bean
//    RabbitAdmin rabbitAdmin(final ConnectionFactory connectionFactory) {
//        return new RabbitAdmin(connectionFactory);
//    }

//    @Bean
//    public SimpleMessageListenerContainer factoryCreatedContainerNoListener(
//            SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory) {
//        SimpleMessageListenerContainer container = rabbitListenerContainerFactory.createListenerContainer();
//        container.setMessageListener(message -> {
//
//        });
//        container.setQueueNames("test.no.listener.yet");
//        return container;
//    }

}
