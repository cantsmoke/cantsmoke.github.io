package com.mycompany.lb2.GUI;

import com.mycompany.lb2.Ork;
import com.mycompany.lb2.gear.Bow;
import javax.swing.*;
import java.awt.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class InfoPanel {
    private JPanel infoPanel;
    private ArmyTree armyTree;

    public InfoPanel(ArmyTree armyTree) {
        infoPanel = createInfoPanel();
        this.armyTree = armyTree;
    }

    private JPanel createInfoPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Информация об орке"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(new JLabel("Тип орка: "), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Племя: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(new JLabel(""), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Оружие: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(new JLabel(""), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Броня: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(new JLabel(""), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Знамя: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(new JLabel(""), gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Сила: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        JProgressBar strengthBar = new JProgressBar(0, 100);
        panel.add(strengthBar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Ловкость: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        JProgressBar agilityBar = new JProgressBar(0, 100);
        panel.add(agilityBar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Интеллект: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        JProgressBar intelligenceBar = new JProgressBar(0, 50);
        panel.add(intelligenceBar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Здоровье: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        JProgressBar healthBar = new JProgressBar(0, 200);
        panel.add(healthBar, gbc);

        return panel;
    }

    public void updateInfoPanel(Ork ork) {
        infoPanel.removeAll();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        String type = "Пехотинец";
        if (ork.getWeapon() instanceof Bow) {
            type = "Разведчик";
        } else if (ork.getBanner() != null) {
            type = "Командир";
        }

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel typeLabel = new JLabel("Тип орка: " + type);
        infoPanel.add(typeLabel, gbc);

        DefaultMutableTreeNode selectedNode = armyTree.getLastSelectedNode();
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode.getParent();
        String tribeName = parent.getUserObject().toString();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        infoPanel.add(new JLabel("Племя: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        infoPanel.add(new JLabel(tribeName), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        infoPanel.add(new JLabel("Имя: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        infoPanel.add(new JLabel(ork.getName()), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        infoPanel.add(new JLabel("Оружие: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        infoPanel.add(new JLabel(ork.getWeapon().getName()), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        infoPanel.add(new JLabel("Броня: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        infoPanel.add(new JLabel(ork.getArmor().getName()), gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        infoPanel.add(new JLabel("Знамя: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        infoPanel.add(new JLabel(ork.getBanner() != null ? ork.getBanner().getName() : "Без знамени"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        infoPanel.add(new JLabel("Сила: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        JProgressBar strengthBar = new JProgressBar(0, 100);
        strengthBar.setValue(ork.getStrength());
        infoPanel.add(strengthBar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        infoPanel.add(new JLabel("Ловкость: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        JProgressBar agilityBar = new JProgressBar(0, 100);
        agilityBar.setValue(ork.getAgility());
        infoPanel.add(agilityBar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        infoPanel.add(new JLabel("Интеллект: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        JProgressBar intelligenceBar = new JProgressBar(0, 50);
        intelligenceBar.setValue(ork.getIntelligence());
        infoPanel.add(intelligenceBar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        infoPanel.add(new JLabel("Здоровье: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        JProgressBar healthBar = new JProgressBar(0, 200);
        healthBar.setValue(ork.getHealth());
        infoPanel.add(healthBar, gbc);

        infoPanel.revalidate();
        infoPanel.repaint();
    }

    public JPanel getPanel() {
        return infoPanel;
    }
}