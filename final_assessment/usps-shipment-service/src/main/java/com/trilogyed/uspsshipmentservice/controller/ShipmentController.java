package com.trilogyed.uspsshipmentservice.controller;

import com.trilogyed.uspsshipmentservice.exception.NotFoundException;
import com.trilogyed.uspsshipmentservice.model.Consumer;
import com.trilogyed.uspsshipmentservice.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
@RequestMapping("/shipment")
public class ShipmentController {

    @Autowired
    ServiceLayer service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Consumer create(@RequestBody Consumer consumer) {

        return service.add(consumer);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Consumer get(@PathVariable("id") int trackingId) {
        Consumer consumer = service.get(trackingId);
        if (consumer == null)
            throw new NotFoundException("Cannot find id: " + trackingId);
        return consumer;

    }

}
