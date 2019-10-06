package com.company.Views;

import com.company.Admin;
import com.company.Admins;
import com.company.Athlete;
import com.company.Athletes;

public class AthleteController {
    Athletes athletes;

    public AthleteController(Athletes athletes) {
        this.athletes = athletes;
    }

    public Athlete Exists(String username, String password){
        for (int i=0;i<athletes.size();i++){
            Athlete a=athletes.get(i);
            if (a.getFirstName().equalsIgnoreCase(username) && a.getPassword().equalsIgnoreCase(password)){
                return a;
            }
        }
        return null;
    }
}
