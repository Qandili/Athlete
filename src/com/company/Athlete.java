package com.company;

import java.util.UUID;

public class Athlete {
    private String id;
    private String firstName;
    private String lastName;
    private String password;
    private String sport;
    private double taille;
    private double poids;
    private int age;
    private Achievements achievements;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }


    public Athlete(String firstName, String lastName, String sport, double taille, double poids, int age) {
        id= UUID.randomUUID().toString();
        achievements=new Achievements();
        password= "1234";
        this.firstName = firstName;
        this.lastName = lastName;
        this.sport = sport;
        this.taille = taille;
        this.poids = poids;
        this.age = age;
    }
    public void addAchievement(Achievement achievement){
        this.achievements.getAchievements().add(achievement);
    }
    public Achievements getAchievements() {
        return achievements;
    }

    public void setAchievements(Achievements achievements) {
        this.achievements = achievements;
    }

    public Athlete(String firstName, String lastName, String password, String sport, double taille, double poids) {
        id=UUID.randomUUID().toString();
        this.firstName = firstName;
        password= "1234";
        this.lastName = lastName;
        this.password = password;
        this.sport = sport;
        this.taille = taille;
        this.poids = poids;
        this.age = age;
    }

    public Athlete() {
        this.firstName = new String();
        this.lastName =  new String();
        this.password =  new String();
        this.sport =  new String();
        this.age = 0;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Athlete(String firstName, String lastName, String password, String sport, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.sport = sport;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sport='" + sport + '\'' +
                ", age=" + age +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
