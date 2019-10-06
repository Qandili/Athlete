package com.company;

public class Achievement {
    private String distance;
    private String timing;
    private String sport;

    public Achievement(String distance, String timing, String sport) {
        this.distance = distance;
        this.timing = timing;
        this.sport = sport;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}
