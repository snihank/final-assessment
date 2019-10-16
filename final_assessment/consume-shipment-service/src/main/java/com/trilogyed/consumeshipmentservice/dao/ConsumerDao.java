package com.trilogyed.consumeshipmentservice.dao;

import com.trilogyed.consumeshipmentservice.model.Consumer;

import java.util.List;
import java.util.concurrent.locks.Condition;

public interface ConsumerDao {

    Consumer create(Consumer consumer);

    Consumer getOne(int trackingId);

    List<Consumer> getAll();

    void delete(int trackingId);


}
