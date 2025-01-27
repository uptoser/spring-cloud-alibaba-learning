package com.uptoser.spring.cloud.alibaba.rockermq.producter;

import com.uptoser.spring.cloud.alibaba.rockermq.producter.config.CustomChannelBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication
@EnableBinding({Sink.class,Source.class, CustomChannelBinder.class})
public class Application {


    @StreamListener(value = CustomChannelBinder.TRANSACTION_INPUT)
    public void receiveTransaction(String msg){
        System.out.println("TRANSACTION_INPUT receive : "+msg+",receiveTime = "+System.currentTimeMillis());
    }
    @StreamListener(value = Sink.INPUT)
    public void receive(String msg){
        System.out.println("TopicTest receive : "+msg+",receiveTime = "+System.currentTimeMillis());
    }
    @StreamListener("Topic-TAG1-Input")
    public void receive1(String messageBody) {
        System.out.println("Receive1: 通过stream收到消息，messageBody = "+messageBody);
    }
    @StreamListener("Topic-TAG2-Input")
    public void receive2(String messageBody) {
        System.out.println("Receive2: 通过stream收到消息，messageBody = "+messageBody);
    }


//    @Autowired
//    private RocketMQTemplate rocketMQTemplate;

//    @PostConstruct
//    private void init() {
//        String msg = "Hello RocketMQ";
//        MessageBuilder builder = MessageBuilder.withPayload(msg)
//                .setHeader(RocketMQHeaders.TAGS, "binder")
//                .setHeader(RocketMQHeaders.KEYS, "my-key")
//                .setHeader("DELAY", "5");
//        Message message = builder.build();
//        rocketMQTemplate.send("TopicTest", message);
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
