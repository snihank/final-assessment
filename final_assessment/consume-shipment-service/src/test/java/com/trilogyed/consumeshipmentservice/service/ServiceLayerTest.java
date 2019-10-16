package com.trilogyed.consumeshipmentservice.service;

import com.trilogyed.consumeshipmentservice.dao.ConsumerDao;
import com.trilogyed.consumeshipmentservice.model.Consumer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceLayerTest {

    ServiceLayer service;
    ConsumerDao dao;

    @Before
    public void setUp() throws Exception {


        setUpConsumerClientMock();

        service = new ServiceLayer(dao);

    }

    public void setUpConsumerClientMock() {
        dao = mock(ConsumerDao.class);
        Consumer c = new Consumer();
        c.setTrackingId(1);
        c.setName("Test");

        Consumer c2 = new Consumer();
        c.setTrackingId(1);
        c.setName("Test");
        List<Consumer> cList = new ArrayList<>();
        cList.add(c);

        doReturn(c).when(dao).create(c2);
        doReturn(c).when(dao).getOne(1);

    }

    @Test
    public void addLevelUp() {
        Consumer c = new Consumer();
        c.setTrackingId(1);
        c.setName("Test");


        c = service.create(c);

        Consumer fromService = service.get(c.getTrackingId());

        assertEquals(c, fromService);
    }

}
