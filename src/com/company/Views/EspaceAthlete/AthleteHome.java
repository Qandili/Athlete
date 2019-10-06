package com.company.Views.EspaceAthlete;

import com.company.Athlete;
import com.company.AthleteSession;
import com.company.Session;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class AthleteHome extends JPanel {
    JLabel firstLabel;
    JTextField firstName;
    JLabel lastnNameLabel;

    JTextField lastName;
    JLabel ageLabel;
    JTextField age;
    JLabel sportLabel;
    JTextField sport;
    JLabel tailleLabel;
    JSlider taille;
    JLabel poidLabel;
    JSlider poids;
    JLabel taillLabel;
    JLabel poidsLabel;
    AthleteSession athleteSession;


    public AthleteHome() {
        Athlete athlete=AthleteSession.getAthlete();
        this.firstName = new JTextField(15);
        firstName.setText(athlete.getFirstName());
        this.lastName = new JTextField(15);
        lastName.setText(athlete.getLastName());
        this.age = new JTextField(15);
        age.setText(String.valueOf(athlete.getAge()));
        this.sport = new JTextField(15);
        sport.setText(athlete.getSport());
        this.taille = new JSlider();
        this.poids = new JSlider();
        taille.setValue((int) athlete.getTaille());
        poids.setValue((int) athlete.getPoids());
        taillLabel=new JLabel();
        poidsLabel=new JLabel();
        firstLabel=new JLabel("firstName");
        lastnNameLabel=new JLabel("Lastname");
        ageLabel=new JLabel("age");
        sportLabel=new JLabel("sport");
        tailleLabel=new JLabel("taille");
        poidLabel=new JLabel("poids");

        firstName.setEnabled(false);
        lastName.setEnabled(false);
        age.setEnabled(false);
        sport.setEnabled(false);
        taille.setEnabled(false);
        poids.setEnabled(false);
        slider(taille,taillLabel);
        slider(poids,poidsLabel);
        setLayout(new GridBagLayout());
        setBounds(0,0,1000,500);
        positionComponents();
        setVisible(true);
    }
    public void slider(JSlider taille,JLabel tlabel){
        taille.setMaximum(100);
        taille.setMinimum(0);
        taille.setValue(30);
        taille.setPaintTicks(true);
        taille.setPaintLabels(true);
        taille.setMinorTickSpacing(10);
        taille.setMajorTickSpacing(20);
        taille.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent event){
                tlabel.setText("Valeur actuelle : " + ((JSlider)event.getSource()).getValue());
            }
        });
    }
    public void positionComponents(){
        GridBagConstraints gbc = new GridBagConstraints();
        //On positionne la case de départ du composant
        gbc.gridx = 0;
        gbc.gridy = 0;
//        gbc.insets=(new Insets(5,5,5,5));
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;


        add(firstLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
//        gbc.insets=(new Insets(5,5,5,5));
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(firstName, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        add(lastnNameLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        add(lastName, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(ageLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(age, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(sportLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(sport, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(tailleLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(taille, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(poidLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(poids, gbc);

    }

}
