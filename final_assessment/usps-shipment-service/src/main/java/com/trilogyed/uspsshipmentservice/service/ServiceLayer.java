package com.trilogyed.uspsshipmentservice.service;

import com.trilogyed.uspsshipmentservice.feign.ConsumerClient;
import com.trilogyed.uspsshipmentservice.model.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceLayer {

    private ConsumerClient client;

    @Autowired
    public ServiceLayer(ConsumerClient client) {
        this.client = client;
    }


    public Consumer add(Consumer consumer) {
        return client.addConsumer(consumer);
    }

    public Consumer get(int trackingId) {
        return client.getConsumer(trackingId);
    }


}
