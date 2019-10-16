package com.trilogyed.uspsshipmentservice.feign;

import com.trilogyed.uspsshipmentservice.model.Consumer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@FeignClient(name = "consume-shipment-service")
public interface ConsumerClient {


    @RequestMapping(value = "/consumer", method = RequestMethod.POST)
    Consumer addConsumer(@RequestBody Consumer consumer);

    @RequestMapping(value = "/consumer/{id}", method = RequestMethod.GET)
    Consumer getConsumer(@PathVariable int trackingId);


}

