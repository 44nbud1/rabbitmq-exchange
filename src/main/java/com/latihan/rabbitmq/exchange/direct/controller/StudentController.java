package com.latihan.rabbitmq.exchange.direct.controller;

import com.latihan.rabbitmq.exchange.direct.model.Student;
import com.latihan.rabbitmq.exchange.direct.producer.StudentProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentProducer studentProducer;

    @PostMapping("/student")
    public String status(@RequestBody Student student)
    {
        studentProducer.sendStudentDirect(student);
        return "kekirim kalik";
    }
}
