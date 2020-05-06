package com.latihan.rabbitmq.exchange.topic.model;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sekolah {

    private String name;
    private String status;

    public Sekolah() {
    }

    public Sekolah(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
