package com.uptoser.spring.cloud.alibaba.rockermq.producter.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 自定义通道 Binder
 */
public interface CustomChannelBinder {

    String TRANSACTION_OUTPUT = "transactionOutput";
    String TRANSACTION_INPUT = "transactionInput";
    String TOPIC_SEND_OUTPUT = "TopicSendOutput";

    @Output(TRANSACTION_OUTPUT)
    MessageChannel transactionOutput();
    @Input(TRANSACTION_INPUT)
    MessageChannel transactionInput();
    @Output(TOPIC_SEND_OUTPUT)
    MessageChannel sendChannel();

    @Input("Topic-TAG1-Input")
    MessageChannel testInputChannel1();

    @Input("Topic-TAG2-Input")
    MessageChannel testInputChannel2();
}
