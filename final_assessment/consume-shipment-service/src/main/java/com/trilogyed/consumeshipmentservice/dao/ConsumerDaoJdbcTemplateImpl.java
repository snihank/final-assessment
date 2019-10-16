package com.trilogyed.consumeshipmentservice.dao;

import com.trilogyed.consumeshipmentservice.exception.NotFoundException;
import com.trilogyed.consumeshipmentservice.model.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConsumerDaoJdbcTemplateImpl implements ConsumerDao{


    // init jdbc
    private JdbcTemplate jdbc;

    // prepared statements
    private static final String INSERT_SQL = "insert into shipment(name) values(?)";
    private static final String SELECT_SQL = "select * from shipment where tracking_id=?";
    private static final String SELECT_ALL_SQl =
            "select * from shipment";
    private static final String DELETE_UP =
            "delete from shipment where tracking_id=?";

    // mapper
    private Consumer mapRowToConsumer(ResultSet rs, int rowNum) throws SQLException {
        Consumer consumer = new Consumer();
        consumer.setTrackingId(rs.getInt("tracking_id"));
        consumer.setName(rs.getString("name"));
        return consumer;
    }


    @Autowired
    public ConsumerDaoJdbcTemplateImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public Consumer create(Consumer consumer) {

            jdbc.update(
                    INSERT_SQL,
                    consumer.getName()
            );

            consumer.setTrackingId(jdbc.queryForObject("select LAST_INSERT_ID()", Integer.class));

            return consumer;
        }


    @Override
    public Consumer getOne(int trackingId) {
        try {
            return jdbc.queryForObject(SELECT_SQL, this::mapRowToConsumer, trackingId);
        } catch (EmptyResultDataAccessException e) {
            // No account matching the given id
            return null;
        }
    }

    @Override
    public List<Consumer> getAll() {
        return jdbc.query(SELECT_ALL_SQl, this::mapRowToConsumer);
    }

    @Override
    public void delete(int trackingId) {
        if (getOne(trackingId) == null) {
            throw new NotFoundException("Consumer id not found");
        }
        jdbc.update(DELETE_UP, trackingId);
    }


}
