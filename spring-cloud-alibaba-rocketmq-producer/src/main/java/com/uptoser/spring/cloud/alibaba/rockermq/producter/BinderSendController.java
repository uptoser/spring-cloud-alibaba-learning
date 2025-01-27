package com.uptoser.spring.cloud.alibaba.rockermq.producter;

import com.uptoser.spring.cloud.alibaba.rockermq.producter.config.CustomChannelBinder;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binder.BinderHeaders;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class BinderSendController {

    @Autowired
    private Source source;
    @Autowired
    private CustomChannelBinder ccb;

    @GetMapping(value = "send")
    public String send(String msg) {
        MessageBuilder builder = MessageBuilder.withPayload(msg);
        Message message = builder.build();
        source.output().send(message);
        return "Hello RocketMQ，RocketMQTemplate send : " + msg;
    }
    @GetMapping(value = "ccbTest")
    public String ccbTest(String msg) {
        for (int j = 0; j < 10; j++) {
            MessageBuilder builder = MessageBuilder.withPayload(msg+":"+j+":"+ System.currentTimeMillis())
                    .setHeader(BinderHeaders.PARTITION_HEADER,0);
            Message message = builder.build();
            ccb.sendChannel().send(message);
        }
        return "CCB send : " + msg;
    }

    @GetMapping(value = "/transaction1")
    public String sendTransactionMsg() {
        Order order = new Order("123", "浙江杭州");
        String transactionId = UUID.randomUUID().toString();
        MessageBuilder builder = MessageBuilder.withPayload(order).setHeader(RocketMQHeaders.TRANSACTION_ID, transactionId);
        Message message = builder.build();

        ccb.transactionOutput().send(message);

        return "OK";
    }
}
