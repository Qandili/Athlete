package com.company;

import java.util.Vector;

public class Achievements {
    private Vector<Achievement> achievements;

    public Achievements() {
        this.achievements = new Vector<>();
    }

    public Vector<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(Vector<Achievement> achievements) {
        this.achievements = achievements;
    }

}
