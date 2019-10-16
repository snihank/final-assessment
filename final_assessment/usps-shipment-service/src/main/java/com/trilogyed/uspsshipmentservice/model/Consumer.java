package com.trilogyed.uspsshipmentservice.model;

import java.util.Objects;

public class Consumer {
    private int trackingId;
    private String name;

    public int getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(int trackingId) {
        this.trackingId = trackingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumer consumer = (Consumer) o;
        return trackingId == consumer.trackingId &&
                Objects.equals(name, consumer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackingId, name);
    }
}
