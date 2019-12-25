package com.gc.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {

    String INPUT = "myMessage";

    String RECIEVE_FALL_BACK = "myMessage2";

    @Input(INPUT)
    SubscribableChannel input();

    @Output(INPUT)
    MessageChannel output();

    @Input(RECIEVE_FALL_BACK)
    SubscribableChannel input2();

    @Output(RECIEVE_FALL_BACK)
    MessageChannel output2();
}
