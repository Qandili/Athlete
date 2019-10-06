package com.company;

import java.util.ArrayList;
import java.util.Vector;

public class Athletes {
    public Vector<Athlete> athletes;

    public Athletes() {
        this.athletes = new Vector<>();
    }
    public int size(){
        return athletes.size();
    }
    public void addNewAthlete(Athlete athlete){
        this.athletes.add(athlete);
    }
    public Athlete get(int index){
        return this.athletes.get(index);
    }
    public void deleteAthlete(int index){
        if (index>athletes.size()){

        }
        athletes.remove(index);
    }
}
