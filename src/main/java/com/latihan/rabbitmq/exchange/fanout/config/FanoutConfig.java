package com.latihan.rabbitmq.exchange.fanout.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {
    private static final String fanoutQueue1 = "guruQueueFanout";
    private static final String fanoutQueue2 = "siswaQueueFanout";

    private static final String fanoutExchange = "fanout-exchange";

    @Bean
    Queue fanoutQueue1()
    {
        return new Queue(fanoutQueue1,true,false,false);
    }

    @Bean
    Queue fanoutQueue2()
    {
        return new Queue(fanoutQueue2,true,false,false);
    }

    @Bean
    FanoutExchange fanout()
    {
        return new FanoutExchange(fanoutExchange);
    }

    @Bean
    Binding binding1()
    {
        return BindingBuilder.bind(fanoutQueue1()).to(fanout());
    }

    @Bean
    Binding binding2()
    {
        return BindingBuilder.bind(fanoutQueue2()).to(fanout());
    }


}
