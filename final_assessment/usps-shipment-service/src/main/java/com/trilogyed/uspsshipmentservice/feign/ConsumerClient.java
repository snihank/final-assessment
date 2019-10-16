package com.trilogyed.uspsshipmentservice.feign;

import com.trilogyed.uspsshipmentservice.model.Consumer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@FeignClient(name = "consumer-shipment-service")
@RequestMapping("/consumer")
public interface ConsumerClient {


   @PostMapping
    Consumer addConsumer(@RequestBody Consumer consumer);

    @GetMapping("/{id}")
    Consumer getConsumer(@PathVariable int id);


}

