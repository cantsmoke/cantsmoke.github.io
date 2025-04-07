package com.mycompany.lb2.GUI;

import com.mycompany.lb2.Ork;
import javax.swing.*;

public class ControlPanel {
    private JPanel panel;
    private JComboBox<String> tribeComboBox;
    private JComboBox<String> roleComboBox;
    private ArmyTree armyTree;

    public ControlPanel(ArmyTree armyTree) {
        this.armyTree = armyTree;
        createPanel();
    }

    private void createPanel() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Создать нового орка:");
        panel.add(titleLabel);

        tribeComboBox = new JComboBox<>(new String[]{"Мордор", "Дол Гулдур", "Мглистые горы"});
        panel.add(tribeComboBox);

        roleComboBox = new JComboBox<>(new String[]{"Базовый", "Командир", "Разведчик"});
        panel.add(roleComboBox);

        JButton createButton = new JButton("Создать орка");
        createButton.addActionListener(e -> {
            String tribe = (String) tribeComboBox.getSelectedItem();
            String role = (String) roleComboBox.getSelectedItem();
            Ork ork = (Ork) OrkFactoryManager.createOrk(tribe, role);
            armyTree.addOrkToTree(ork, tribe);
        });
        panel.add(createButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}
