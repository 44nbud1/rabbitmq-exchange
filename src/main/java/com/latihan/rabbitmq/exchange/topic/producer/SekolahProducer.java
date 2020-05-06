package com.latihan.rabbitmq.exchange.topic.producer;

import com.latihan.rabbitmq.exchange.topic.model.Sekolah;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SekolahProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private static final String Exchange = "topic-exchange";

    private static final String routingKey1 = "sekolah";
    private static final String routingKey2 = "guru.sekolah";
    private static final String routingKey3 = "pegawai.sekolah";
    private static final String routingKey4 = "pegawai.kontrak";

    public void send(Sekolah sekolah)
    {
        amqpTemplate.convertAndSend(Exchange,routingKey2,sekolah);
    }
}
