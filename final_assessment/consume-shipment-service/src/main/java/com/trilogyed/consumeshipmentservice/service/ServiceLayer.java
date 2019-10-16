package com.trilogyed.consumeshipmentservice.service;

import com.trilogyed.consumeshipmentservice.dao.ConsumerDao;
import com.trilogyed.consumeshipmentservice.model.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceLayer {
    private ConsumerDao dao;

    @Autowired
    public ServiceLayer(ConsumerDao dao) {
        this.dao = dao;
    }

    public Consumer create(Consumer consumer){
       return dao.create(consumer);
    }

    public Consumer get(int trackingId){
        return dao.getOne(trackingId);
    }

    public List<Consumer> getAll() {
        return dao.getAll();
    }

}
