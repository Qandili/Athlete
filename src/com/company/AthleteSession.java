package com.company;

public class AthleteSession {
    private static  Athlete athlete;

    public AthleteSession() {
        athlete=new Athlete();
    }

    public static Athlete getAthlete() {
        return athlete;
    }

    public static void setAthlete(Athlete Athlete) {
        athlete = Athlete;
    }
    public static void destory(){
        athlete=null;
    }
}
