package com.company.Views;

import javax.swing.*;

public class AchievementsPanel extends JPanel {
    MainFrame root;

    JTable achievements;
    public AchievementsPanel(MainFrame root) {
        this.root=root;
        root.setTitle("Achievements in development");
    }
}
