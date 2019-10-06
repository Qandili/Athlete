package com.company.Views;

import com.company.Sport;

import java.util.Vector;

public class Sports {
    private Vector<Sport> sports;

    public Sports() {
        sports=new Vector<>();
    }

    public Vector<Sport> getSports() {
        return sports;
    }

    public void setSports(Vector<Sport> sports) {
        this.sports = sports;
    }
    public void addNewSport(Sport sport){
        this.sports.add(sport);
    }
}
