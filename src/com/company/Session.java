package com.company;

public class Session {
    private static Admin admin;

    public Session() {
        admin=new Admin();
    }

    public static Admin getAdmin() {
        return admin;
    }

    public static void setAdmin(Admin admin) {
        Session.admin = admin;
    }
    public static void destory(){
        admin=null;
    }
}
