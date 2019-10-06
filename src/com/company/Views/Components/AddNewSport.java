package com.company.Views.Components;

import com.company.Athlete;
import com.company.Helpers.AthleteModel;
import com.company.Sport;
import com.company.Views.AdminHome;
import com.company.Views.MainFrame;
import com.company.Views.Sports;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

public class AddNewSport extends JPanel implements ListSelectionListener,ActionListener {
    SportForm sportForm;
    JButton back;
    MainFrame root;
    JList<Sport> jSports;
    Sports sports;
    public AddNewSport(MainFrame root) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.root=root;
        back=new JButton("back");
        sportForm=new SportForm(this,root);
        sports=new Sports();
        jSports=new JList<Sport>(sports.getSports());
        JScrollPane scrollPane=new JScrollPane(jSports);
        // set Orientation for slider
        JSplitPane sl = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sportForm, scrollPane);
        sl.setOneTouchExpandable(true);
        sl.setDividerLocation(0.5);
//        sl.setOrientation(SwingConstants.VERTICAL);
        add(back);
        add(sl);
        root.setSports(sports);
        back.addActionListener(this);
        // add panel
//        add(scrollPane);
//        add(new AthleteForm(athletes,athleteModel,athleteTable));
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back){
            root.setContentPane(new AdminHome(root));
        }
    }
}
class SportForm extends JPanel implements ActionListener{
    JTextField sport;
    JButton save;
    JLabel error;
    AddNewSport addNewSport;
    MainFrame root;
    public SportForm(AddNewSport addNewSport,MainFrame root) {
        this.addNewSport=addNewSport;
        this.root=root;
        setLayout(new GridBagLayout());
        this.sport = new JTextField(15);
        error=new JLabel();
        this.save =new  JButton("Save");
        save.addActionListener(this);
        error.setForeground(Color.red);

        positionComponents();
    }

    private void positionComponents(){
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=(new Insets(0,1,0,1));
        gbc.gridx = 0;
        gbc.gridy = 0;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(sport,gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(error,gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(save,gbc);
    }
    public boolean sportExists(String sport){
        String a;
        for (int i=0;i<addNewSport.jSports.getModel().getSize();i++){
            a=(String) addNewSport.jSports.getModel().getElementAt(i).getSport();
            if (a.equalsIgnoreCase(sport) ){
                return true;
            }
        }
        return false;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==save){
            String spo=sport.getText();

            if (spo.equalsIgnoreCase("")){
                error.setText("wrong entry");
            }else {
                if (sportExists(spo)){
                    error.setText("Already exists");
                }else {
                    error.setText("");
                    this.addNewSport.sports.addNewSport(new Sport(spo));
                    addNewSport.jSports.updateUI();

                }

            }

        }
    }

}