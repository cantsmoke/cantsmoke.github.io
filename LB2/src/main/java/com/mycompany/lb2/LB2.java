package com.mycompany.lb2;

import javax.swing.SwingUtilities;

public class LB2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
