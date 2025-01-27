package com.uptoser.spring.cloud.alibaba.rockermq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding({Sink.class})
public class SpringCloudRocketMQApplication {

    @StreamListener(value = Sink.INPUT)
    public void receive(String msg){
        System.out.println("TopicTest receive : "+msg+",receiveTime = "+System.currentTimeMillis());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRocketMQApplication.class, args);
    }
}
