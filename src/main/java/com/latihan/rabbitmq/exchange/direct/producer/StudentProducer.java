package com.latihan.rabbitmq.exchange.direct.producer;

import com.latihan.rabbitmq.exchange.direct.model.Student;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentProducer {

    private static final String exchangeDirect = "direct-Exchange";

    private static final String routingKeyDirect1 = "siswa";
    private static final String routingKeyDirect2 = "guru";

    @Autowired
    private AmqpTemplate amqpTemplate;



    public void sendStudentDirect(Student student)
    {
        amqpTemplate.convertAndSend(exchangeDirect,routingKeyDirect2,student);
    }
}
