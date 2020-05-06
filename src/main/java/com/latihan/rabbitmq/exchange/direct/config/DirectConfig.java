package com.latihan.rabbitmq.exchange.direct.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig
{
    private static final String queueDirect1 = "siswaQueue";
    private static final String queueDirect2 = "guruQueue";

    private static final String exchangeDirect = "direct-Exchange";

    private static final String routingKeyDirect1 = "siswa";
    private static final String routingKeyDirect2 = "guru";

    @Bean
    Queue directQueue1()
    {
        return new Queue(queueDirect1,true,false,false);
    }

    @Bean
    Queue directQueue2()
    {
        return new Queue(queueDirect2,true,false,false);
    }

    @Bean
    DirectExchange directExchange()
    {
        return new DirectExchange(exchangeDirect);
    }

    @Bean
    Binding directBinding1()
    {
        return BindingBuilder.bind(directQueue1()).to(directExchange()).with(routingKeyDirect1);
    }

    @Bean
    Binding directBinding2()
    {
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with(routingKeyDirect2);
    }

    @Bean
    MessageConverter jsonMessageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    AmqpTemplate amqpTemplate (ConnectionFactory connectionFactory)
    {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
