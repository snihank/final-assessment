package com.trilogyed.consumeshipmentservice.controller;

import com.trilogyed.consumeshipmentservice.exception.NotFoundException;
import com.trilogyed.consumeshipmentservice.model.Consumer;
import com.trilogyed.consumeshipmentservice.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    ServiceLayer service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Consumer addConsumer(@RequestBody Consumer consumer) {
        return service.create(consumer);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Consumer getConsumer(@PathVariable int id) {
        Consumer consumer = service.get(id);
        if (consumer == null)
            throw new NotFoundException("Cannot find id: " + id);
        return consumer;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Consumer> getAll() {
        return service.getAll();
    }



}
