package com.latihan.rabbitmq.exchange.topic.controller;

import com.latihan.rabbitmq.exchange.topic.model.Sekolah;
import com.latihan.rabbitmq.exchange.topic.producer.SekolahProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SekolahController {

    @Autowired
    private SekolahProducer sekolahProducer;

    @PostMapping("/coba")
    public String send(@RequestBody Sekolah sekolah)
    {
        sekolahProducer.send(sekolah);
        return "Oke banget";
    }
}
