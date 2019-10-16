package com.trilogyed.uspsshipmentservice.service;

import com.trilogyed.uspsshipmentservice.feign.ConsumerClient;
import com.trilogyed.uspsshipmentservice.model.Consumer;
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
//        c.setCommentId(1);
        c.setName("Test");
        List<Consumer> cList = new ArrayList<>();
        cList.add(c);

        doReturn(c).when(client).addConsumer(c2);
        doReturn(c).when(client).getConsumer(1);

    }

    @Test
    public void saveFindConsumer(){
        Consumer consumer = new Consumer();
        consumer.setName("Test");

        consumer = service.add(consumer);

        Consumer c = service.get(consumer.getTrackingId());

        assertEquals(consumer, c);

    }



}
