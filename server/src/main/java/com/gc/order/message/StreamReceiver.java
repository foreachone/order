package com.gc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.RECIEVE_FALL_BACK)
    public String process(Object message) {
        log.info("StreamReceiver:{}", message);
        return "received";
    }
    @StreamListener(StreamClient.RECIEVE_FALL_BACK)
    public void process2(Object message) {
        log.info("StreamReceiver-fallback:{}", message);
    }
}
