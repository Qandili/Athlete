package com.company;

import java.util.UUID;

public class Sport {
    private String id;
    private String sport;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Sport(String sport) {
        id= UUID.randomUUID().toString();
        this.sport = sport;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        return sport;

    }
}
