package com.trilogyed.uspsshipmentservice.service;

import com.trilogyed.uspsshipmentservice.feign.ConsumerClient;
import com.trilogyed.uspsshipmentservice.model.Consumer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceLayerTest {


    ServiceLayer service;
    ConsumerClient client;

    @Before
    public void setUp() throws Exception {


        setUpConsumerClientMock();

        service = new ServiceLayer(client);

    }

    public void setUpConsumerClientMock() {
        client = mock(ConsumerClient.class);
        Consumer c = new Consumer();
        c.setTrackingId(1);
        c.setName("Test");

        Consumer c2 = new Consumer();
//        c.setTrackingId(1);
        c.setName("Test");
        List<Consumer> cList = new ArrayList<>();
        cList.add(c);

        doReturn(c).when(client).addConsumer(c2);
        doReturn(c).when(client).getConsumer(1);

    }

    @Test
    public void getConsumer(){
        Consumer consumer = new Consumer();
        consumer.setTrackingId(1);
        consumer.setName("Test");
        service.add(consumer);

        Consumer c = service.get(consumer.getTrackingId());

        assertEquals(c, consumer);

    }



}
