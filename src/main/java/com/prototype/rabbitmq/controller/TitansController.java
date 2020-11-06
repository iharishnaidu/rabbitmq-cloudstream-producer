package com.prototype.rabbitmq.controller;

import com.prototype.rabbitmq.channel.TitansChannel;
import com.prototype.rabbitmq.model.Titans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(TitansChannel.class)
public class TitansController {

    @Autowired TitansChannel titansChannel;

    @RequestMapping("/assemble")
    @ResponseBody
    public String orderFood(@RequestBody Titans titan) {
        titansChannel.titansBattle().send(MessageBuilder.withPayload(titan).build());
        System.out.println(titan.toString());
        return "Titan Assembled";
    }

}
