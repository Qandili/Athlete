package com.company.Views;

import com.company.*;
import com.company.Views.EspaceAthlete.AthleteHome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener{
    AdminController adminController;
    AthleteController athleteController;
    public Athletes athletes;
    Athlete athlete;
    Admins admins;
    Admin admin;
    JMenuBar menuBar;
    JMenu options;
    JMenuItem logout;
    JMenuBar adminMenu;
    JMenu menuOptions;
    JMenuItem adminItem;
    JMenuItem athleteMembership;

    public Sports getSports() {
        return sports;
    }

    public void setSports(Sports sports) {
        this.sports = sports;
    }

    private Sports sports;
    public MainFrame() throws HeadlessException {
        setTitle("Admin Login");
        setBounds(0,0,1000,500);
        setLocationRelativeTo(null);
        this.add(new AdminPanel(this));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        athletes=new Athletes();
        admins=new Admins();
        sports=new Sports();
        admins.addNewAthlete(new Admin("mohamed","elqandili","1234"));
        adminController=new AdminController(admins);
        athleteController=new AthleteController(athletes);
        System.out.println("main frame");
        for (int i = 0; i <athletes.size() ; i++) {
            System.out.println(this.athletes.get(i));
        }        setBackground(Color.gray);
        setMenu();
        setVisible(true);
    }
    public void setMenu(){
        if (Session.getAdmin()!=null){
            menuBar=new JMenuBar();
            options=new JMenu("options");
            logout= new JMenuItem("logout");
            options.add(logout);
            menuBar.add(options);
            setJMenuBar(menuBar);
            logout.addActionListener(this);
        }else {
            adminMenu=new JMenuBar();
            menuOptions=new JMenu("options");
            adminItem= new JMenuItem("admin");
            athleteMembership= new JMenuItem("athlete");
            menuOptions.add(adminItem);
            menuOptions.add(athleteMembership);
            adminMenu.add(menuOptions);
            setJMenuBar(adminMenu);
            adminItem.addActionListener(this);
            athleteMembership.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==logout){
            Session.destory();
            System.out.println("logout");
            setContentPane(new AdminPanel(this));
            setMenu();
            setVisible(true);
        }else if(e.getSource()==adminItem){
            setTitle("Espace Admin");
            setContentPane(new AdminPanel(this));
            setVisible(true);
        }else if (e.getSource()==athleteMembership){
            setTitle("Espace Athlete");
            setContentPane(new AthletePanel(this));
            setVisible(true);
        }
    }
}

class AthletePanel extends JPanel implements ActionListener{
    JLabel athleteSpace;
    JTextField loginName;
    JPasswordField password;
    JButton login;
    MainFrame root;
    public AthletePanel(MainFrame a) {
        setLayout(new GridBagLayout());
        root=a;
        login=new JButton("login");
        loginName=new JTextField(15);
        password=new JPasswordField(15);
        athleteSpace=new JLabel("Espace Athlete");
        login.addActionListener(this);
        positionComponents();

    }
    public void positionComponents(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets=(new Insets(5,5,5,5));
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        add(athleteSpace, gbc);
        //On positionne la case de départ du composant
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets=(new Insets(5,5,5,5));
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        add(loginName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        add(password, gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(login, gbc);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String pass=new String(password.getPassword());
        System.out.println(loginName.getText());
        System.out.println(pass);
        Athlete athlete = null;
        athlete=root.athleteController.Exists(loginName.getText(),pass);
        if (athlete==null){
            System.out.println("no way");
        }else {
            //here we are adding our athlete to the session after login in
            AthleteSession.setAthlete(athlete);
            root.setContentPane(new AthleteHome());
            System.out.println(AthleteSession.getAthlete());
            root.setMenu();
            root.setVisible(true);
            root.athlete=athlete;
        }
    }

}

class AdminPanel extends JPanel implements ActionListener{
    JLabel espaceAdmin;
    JTextField loginName;
    JPasswordField password;
    JButton login;
    MainFrame root;
    public AdminPanel(MainFrame a) {
        setLayout(new GridBagLayout());
        root=a;
        login=new JButton("login");
        loginName=new JTextField(15);
        password=new JPasswordField(15);
        espaceAdmin=new JLabel("Espace Admin");
        login.addActionListener(this);
        positionComponents();

    }
    public void positionComponents(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets=(new Insets(5,5,5,5));
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        add(espaceAdmin, gbc);
        //On positionne la case de départ du composant
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets=(new Insets(5,5,5,5));
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        add(loginName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        add(password, gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(login, gbc);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String pass=new String(password.getPassword());
        System.out.println(loginName.getText());
        System.out.println(pass);
        Admin admin = null;
            admin=root.adminController.Exists(loginName.getText(),pass);
            System.out.println(admin);
        if (admin==null){
            System.out.println("no way");
        }else {
            //here we are adding our athlete to the session after login in
            Session.setAdmin(admin);
        root.setContentPane(new AdminHome(root));
            System.out.println(Session.getAdmin());
        root.setMenu();
        root.setVisible(true);
        root.admin=admin;
        }
    }

}
