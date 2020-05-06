package com.latihan.rabbitmq.exchange.topic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicExchangeConfig {

    private static final String topicQueue1 = "guruTopicqueue";
    private static final String topicQueue2 = "siswaTopicqueue";
    private static final String topicQueue3 = "pegawaiTopicqueue";
    private static final String topicQueue4 = "honorerTopicqueue";

    private static final String Exchange = "topic-exchange";

    private static final String routingKey1 = "siswa.sekolah.*";
    private static final String routingKey2 = "*.sekolah";
    private static final String routingKey3 = "pegawai.sekolah.*";
    private static final String routingKey4 = "pegawai.kontrak";

    @Bean
    Queue queue1()
    {
        return new Queue(topicQueue1,true,false,false);
    }

    @Bean
    Queue queue2()
    {
        return new Queue(topicQueue2,true,false,false);
    }

    @Bean
    Queue queue3()
    {
        return new Queue(topicQueue3,true,false,false);
    }

    @Bean
    Queue queue4()
    {
        return new Queue(topicQueue4,true,false,false);
    }

    @Bean
    TopicExchange topicExchange()
    {
        return new TopicExchange(Exchange);
    }

    @Bean
    Binding binding1Topic(Queue queue1,TopicExchange topicExchange)
    {
        return BindingBuilder.bind(queue1).to(topicExchange).with(routingKey2);
    }

    @Bean
    Binding binding2Topic(Queue queue2,TopicExchange topicExchange)
    {
        return BindingBuilder.bind(queue2).to(topicExchange).with(routingKey2);
    }

    @Bean
    Binding binding3Topic(Queue queue3,TopicExchange topicExchange)
    {
        return BindingBuilder.bind(queue3).to(topicExchange).with(routingKey2);
    }

    @Bean
    Binding binding4Topic(Queue queue4,TopicExchange topicExchange)
    {
        return BindingBuilder.bind(queue4).to(topicExchange).with(routingKey2);
    }
}
