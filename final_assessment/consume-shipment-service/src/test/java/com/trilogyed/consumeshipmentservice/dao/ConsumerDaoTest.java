package com.trilogyed.consumeshipmentservice.dao;

import com.trilogyed.consumeshipmentservice.model.Consumer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerDaoTest {

    @Autowired
    private ConsumerDao dao;


    @Before
    public void setUp() throws Exception{
        List<Consumer> consumer = dao.getAll();
        for (Consumer c : consumer) {
            dao.delete(c.getTrackingId());
        }

    }

    @Test
    public void addGetDelete() {

        Consumer c = new Consumer();
//        c.setTrackingId(1);
        c.setName("Test");


        c = dao.create(c);

        Consumer c1 = dao.getOne(c.getTrackingId());
        assertEquals(c1, c);

        dao.delete(c.getTrackingId());
        assertEquals(0, dao.getAll().size());

    }


}