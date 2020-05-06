package com.latihan.rabbitmq.exchange.fanout.producer;

import com.latihan.rabbitmq.exchange.fanout.model.DataSiswa;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataSiswaFanout {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private static final String fanoutExchange = "fanout-exchange";

    @PostMapping("/add")
    public String addKeRabbit(@RequestBody DataSiswa dataSiswa)
    {
        amqpTemplate.convertAndSend(fanoutExchange,"",dataSiswa);
        return "oke mungkin";
    }
}
