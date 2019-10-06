package com.company;

import java.util.ArrayList;

public class Admins {
    public ArrayList<Admin> admins;

    public Admins() {
        this.admins = new ArrayList();
    }
    public int size(){
        return admins.size();
    }
    public void addNewAthlete(Admin admin){
        this.admins.add(admin);
    }
    public Admin get(int index){
        return this.admins.get(index);
    }
    public void deleteAthlete(int index){
        if (index>admins.size()){

        }
        admins.remove(index);
    }
}

