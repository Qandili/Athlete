package com.company.Views;

import com.company.Athlete;
import com.company.Helpers.AthleteModel;
import com.company.Views.Components.AddNewSport;
import com.company.Views.Components.ManageAthletes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class AdminHome extends JPanel implements ActionListener {
    JButton addSports;
    JButton addAdmin;
    JButton athleteList;
    JButton insertAchievements;
    MainFrame root;
    AthleteModel athleteModel;
    Vector<Athlete> athletes;

    public AdminHome(MainFrame a) throws HeadlessException {
        setLayout(new GridBagLayout());
        setBounds(0,0,1000,500);
        initialize(a);
        setActionListeners();
        positionComponents();
        setBackground(Color.darkGray);
        setVisible(true);
    }
    public void initialize(MainFrame a){
        root=a;
        addAdmin=new JButton("Add new Admin");
        athleteList=new JButton("Check Athletes");
        addSports=new JButton("Add new Sport");
        insertAchievements=new JButton("Add Achievement");
        athletes=new Vector<Athlete>();
        athleteModel=new AthleteModel(athletes);
    }
    /**
     * This function is used to set action listeners to our subconmponents
     * t
     */
    private void setActionListeners(){
        athleteList.addActionListener(this);
        addSports.addActionListener(this);
        insertAchievements.addActionListener(this);
    }

    public void positionComponents(){
        buttonsStyling();
        GridBagConstraints gbc = new GridBagConstraints();
        //On positionne la case de départ du composant
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets=(new Insets(5,5,5,5));
        //La taille en hauteur et en largeur
        gbc.gridheight = 2;
        gbc.gridwidth = 2;


        add(addAdmin, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        //La taille en hauteur et en largeur
        gbc.gridheight = 2;
        gbc.gridwidth = 2;

        add(athleteList, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        //La taille en hauteur et en largeur
        gbc.gridheight = 2;
        gbc.gridwidth = 2;
        add(addSports, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        //La taille en hauteur et en largeur
        gbc.gridheight = 2;
        gbc.gridwidth = 2;
        add(insertAchievements, gbc);

    }

    /**
     * @return void
     * This function is used for buttons Styling
     * it has border styles
     * setting images
     */
    public void buttonsStyling(){
        addAdmin.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.white, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        addAdmin.setForeground(Color.white);
        athleteList.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.white, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        athleteList.setForeground(Color.white);
        addSports.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.white, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        addSports.setForeground(Color.white);
        insertAchievements.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.white, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        insertAchievements.setForeground(Color.white);
        try {
            Image img = ImageIO.read(getClass().getResource("../resources/plus.png"));
            addAdmin.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {
            Image img = ImageIO.read(getClass().getResource("../resources/eye.png"));
            athleteList.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {
            Image img = ImageIO.read(getClass().getResource("../resources/football.png"));
            addSports.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {
            Image img = ImageIO.read(getClass().getResource("../resources/award.png"));
            insertAchievements.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==athleteList){
            root.setContentPane(new ManageAthletes(root));
            root.setVisible(true);
        }else if (e.getSource()==addSports){
            root.setContentPane(new AddNewSport(root));
            root.setVisible(true);
        }else if(e.getSource()==insertAchievements){
            root.setContentPane(new AchievementsPanel(root));
            root.setVisible(true);
        }
    }
}

