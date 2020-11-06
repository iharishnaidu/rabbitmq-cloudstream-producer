package com.prototype.rabbitmq.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TitansChannel {

    @Output("titansChannel")
    MessageChannel titansBattle();

}
