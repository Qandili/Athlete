package com.company.Views;

import com.company.Admin;
import com.company.Admins;
import com.company.Athlete;
import com.company.Athletes;

public class AdminController {
    Admins admins;

    public AdminController(Admins admins) {
        this.admins = admins;
    }

    public Admin Exists(String username, String password){
        for (int i=0;i<admins.size();i++){
            Admin a=admins.get(i);
            if (a.getFirstName().equalsIgnoreCase(username) && a.getPassword().equalsIgnoreCase(password)){
                return a;
            }
        }
        return null;
    }
}
