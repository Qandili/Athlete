package com.company.Views.Components;

import com.company.Athlete;
import com.company.Athletes;
import com.company.Helpers.AthleteModel;
import com.company.Sport;
import com.company.Views.AdminHome;
import com.company.Views.MainFrame;
import javafx.scene.control.Slider;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ManageAthletes extends JPanel implements ListSelectionListener,ActionListener{
    private JTable athleteTable;
    private AthleteModel athleteModel;
    Vector athletes;
    AthleteForm athleteForm;
    JButton back;
    MainFrame root;
    public ManageAthletes(MainFrame root) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.root=root;
        back=new JButton("back");
        add(back);
        athletes = root.athletes.athletes;
        athleteModel = new AthleteModel(athletes);
        athleteTable = new JTable(athleteModel);
        athleteTable.updateUI();
        athleteForm= new AthleteForm(athletes,athleteModel,athleteTable,root);

        JScrollPane scrollPane = new JScrollPane(athleteTable);
        JSplitPane sl = new JSplitPane(SwingConstants.VERTICAL,athleteForm, scrollPane);
        // set Orientation for slider
        sl.setOrientation(SwingConstants.VERTICAL);

        add(sl);
        athleteTable.getSelectionModel().addListSelectionListener(this);
        back.addActionListener(this);
        // add panel
//        add(scrollPane);
//        add(new AthleteForm(athletes,athleteModel,athleteTable));
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        athleteForm.firstName.setText(athleteTable.getValueAt(athleteTable.getSelectedRow(), 0).toString());
        athleteForm.lastName.setText(athleteTable.getValueAt(athleteTable.getSelectedRow(), 1).toString());
//        athleteForm.sport.setSelectedValue(athleteTable.getValueAt(athleteTable.getSelectedRow(), ).toString());
        athleteForm.age.setValue((Integer)athleteTable.getValueAt(athleteTable.getSelectedRow(), 3));
        Integer taille;
        try{
            taille=Integer.parseInt(athleteTable.getValueAt(athleteTable.getSelectedRow(), 4).toString());

        }catch (Exception e1){
            taille=0;
        }

        athleteForm.taille.setValue( taille);
        Integer poids;
        try {
            poids=Integer.parseInt(athleteTable.getValueAt(athleteTable.getSelectedRow(), 5).toString());

        }catch (Exception e2){
            poids=0;
        }
        athleteForm.poids.setValue(poids);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back){
            root.setContentPane(new AdminHome(root));
        }
    }
}
class AthleteForm extends JPanel implements ActionListener{
    JLabel firstNamelablel;
    JTextField firstName;
    JLabel lastNamelabel;

    JTextField lastName;
    JLabel sportLabel;

    JList<Sport> sport;
    JLabel ageLabel;

    JSpinner age;
    private JLabel plabel;
    private JLabel tlabel;
    JLabel tailleLabel;

    JSlider taille;
    JLabel poidsLabel;

    JSlider poids;

    JButton clear;
    JButton save;
    JButton remove;
    JButton edit;
    JLabel error;

    Vector athletes;
    AthleteModel amodel;
    JTable mtable;
    MainFrame root;


    public AthleteForm(Vector a,AthleteModel athleteModel,JTable j,MainFrame root) {
        athletes=a;
        amodel=athleteModel;
        mtable=j;
        this.root=root;
        setLayout(new GridBagLayout());
        firstNamelablel=new JLabel("FirstName");
        firstName=new JTextField(15);
        lastNamelabel=new JLabel("lastName");
        lastName=new JTextField(15);
        sportLabel=new JLabel("Sport");
        sport=new JList<Sport>(root.getSports().getSports());
        sport.setSelectedIndex(0);
        ageLabel=new JLabel("Age");
        age=new JSpinner(fillAgeSpinner());
        clear=new JButton("clear");
        remove=new JButton("remove");
        edit=new JButton("edit");
        save=new JButton("save");
        error=new JLabel("");
        error.setForeground(Color.red);
        Component mySpinnerEditor = age.getEditor();
        JFormattedTextField jftf = ((JSpinner.DefaultEditor) mySpinnerEditor).getTextField();
        jftf.setColumns(5);
        tailleLabel=new JLabel("Taille");

        taille=new JSlider();
        poidsLabel=new JLabel("Poids");

        poids=new JSlider();
        tlabel = new JLabel("Valeur actuelle : 30");
        plabel = new JLabel("Valeur actuelle : 30");
        addComponents();
        save.addActionListener(this);
        clear.addActionListener(this);
        remove.addActionListener(this);
        edit.addActionListener(this);

    }
    public void addComponents(){
        GridBagConstraints gbc = new GridBagConstraints();
        //On positionne la case de départ du composant
//        gbc.insets=(new Insets(5,5,5,5));
        gbc.gridx = 0;
        gbc.gridy = 0;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(firstNamelablel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        add(firstName, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(lastNamelabel, gbc);
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
        add(sportLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(sport, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(ageLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(age, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(tlabel,gbc);
        slider(taille,tlabel);
        gbc.gridx = 0;
        gbc.gridy = 5;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(tailleLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(taille, gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(plabel,gbc);
        slider(poids,plabel);
        gbc.gridx = 0;
        gbc.gridy = 7;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(poidsLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 7;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(poids, gbc);



        gbc.insets=(new Insets(1,1,1,1));
        gbc.gridx = 1;
        gbc.gridy = 8;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(error, gbc);
        gbc.gridx = 1;
        gbc.gridy = 9;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(clear, gbc);
        gbc.gridx = 1;
        gbc.gridy = 10;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(save, gbc);
        gbc.insets=(new Insets(1,0,1,0));
        gbc.gridx = 1;
        gbc.gridy = 11;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(remove, gbc);
        gbc.gridx = 1;
        gbc.gridy = 12;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(edit, gbc);

    }

    /**
     * This methods empty all the text fields in the form
     */
    public void clear(){
        firstName.setText("");
        lastName.setText("");
        sport.setSelectedIndex(0);
        age.setValue(0);
    }
    public SpinnerModel fillAgeSpinner(){
        Integer[] list=new Integer[40];
        for (int i = 0; i <40 ; i++) {
            list[i]=(i);
        }
        SpinnerModel ageModel=new SpinnerListModel(Arrays.asList(list));
        return ageModel;
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
        add(taille);
    }

    public Athlete saveAthlete(){

        return new Athlete(firstName.getText(),
                lastName.getText(),sport.getSelectedValue().getSport(), taille.getValue(),poids.getValue(),(int) age.getValue());
    }
    public boolean athleteExists(Athlete athlete){
        String a;
        String b;
        String c;
        for (int i=0;i<mtable.getRowCount();i++){
            a=(String) mtable.getValueAt(i,0);
            b=(String) mtable.getValueAt(i,1);
//            c= (String) mtable.getValueAt(i,2);
            if (a.equalsIgnoreCase(athlete.getFirstName()) && b.equalsIgnoreCase(athlete.getLastName())){
                return true;
            }
        }
        return false;
    }
    public void removeSelected(int index){
        ((AthleteModel)mtable.getModel()).removeElement(index);
    }
    public void editSelected(int index){
        Athlete a=saveAthlete();
        ((AthleteModel)mtable.getModel()).editElement(a,index);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==save){
            if (!athleteExists(saveAthlete())){
                athletes.add(saveAthlete());
                amodel=new AthleteModel(athletes);
                root.athletes.athletes=athletes;
                for (int i = 0; i <athletes.size() ; i++) {
                    System.out.println(root.athletes.get(i));
                }
                mtable.updateUI();
                error.setText("");
            }else {
                error.setText("Athlete Already Exists !");
            }
        }else if(e.getSource()==clear){
            clear();
            error.setText("");
        }else if(e.getSource()==remove){
            removeSelected(mtable.getSelectedRow());
            mtable.updateUI();
        }else if(e.getSource()==edit){
            editSelected(mtable.getSelectedRow());
            mtable.updateUI();
        }
    }
}