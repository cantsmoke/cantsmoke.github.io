package com.mycompany.lb2;

import com.mycompany.lb2.gear.Bow;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class MainFrame extends JFrame {
    private JTree armyTree;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode root;
    private JPanel controlPanel;
    private JPanel infoPanel;

    public MainFrame() {
        setTitle("Армия Мордора");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        root = new DefaultMutableTreeNode("Армия Мордора");
        treeModel = new DefaultTreeModel(root);
        armyTree = new JTree(treeModel);

        controlPanel = createControlPanel();

        infoPanel = createInfoPanel();

        add(new JScrollPane(armyTree), BorderLayout.CENTER);
        add(controlPanel, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.EAST);

        armyTree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) armyTree.getLastSelectedPathComponent();
            if (selectedNode != null && selectedNode.getUserObject() instanceof Ork) {
                Ork selectedOrk = (Ork) selectedNode.getUserObject();
                updateInfoPanel(selectedOrk);
            }
        });
    }

    private JPanel createControlPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Создать нового орка:");
        panel.add(titleLabel);

        JComboBox<String> tribeComboBox = new JComboBox<>(new String[]{"Мордор", "Дол Гулдур", "Мглистые горы"});
        panel.add(tribeComboBox);

        JComboBox<String> roleComboBox = new JComboBox<>(new String[]{"Базовый", "Командир", "Разведчик"});
        panel.add(roleComboBox);

        JButton createButton = new JButton("Создать орка");
        createButton.addActionListener(e -> {
            String tribe = (String) tribeComboBox.getSelectedItem();
            String role = (String) roleComboBox.getSelectedItem();
            Ork ork = createOrk(tribe, role);
            addOrkToTree(ork, tribe);
        });
        panel.add(createButton);

        return panel;
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
        JLabel typeLabel = new JLabel("Тип орка: ");
        panel.add(typeLabel, gbc);

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
    
    private void updateInfoPanel(Ork ork) {
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

        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) armyTree.getLastSelectedPathComponent();
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

    private Ork createOrk(String tribe, String role) {
        OrkBuilderFactory factory = switch (tribe) {
            case "Мордор" -> new MordorOrkBuilderFactory();
            case "Дол Гулдур" -> new DolGuldurOrkBuilderFactory();
            case "Мглистые горы" -> new MistyMountainsOrkBuilderFactory();
            default -> throw new IllegalArgumentException("Неизвестное племя");
        };

        OrcDirector director = new OrcDirector(factory.createOrkBuilder());

        return switch (role) {
            case "Базовый" -> director.createBasicOrk();
            case "Командир" -> director.createLeaderOrk();
            case "Разведчик" -> director.createScoutOrk();
            default -> throw new IllegalArgumentException("Неизвестная роль");
        };
    }

    private void addOrkToTree(Ork ork, String tribe) {
        DefaultMutableTreeNode tribeNode = findOrCreateTribeNode(tribe);
        DefaultMutableTreeNode orkNode = new DefaultMutableTreeNode(ork);
        tribeNode.add(orkNode);
        treeModel.reload();
    }

    private DefaultMutableTreeNode findOrCreateTribeNode(String tribe) {
        for (int i = 0; i < root.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) root.getChildAt(i);
            if (child.getUserObject().equals(tribe)) {
                return child;
            }
        }
        DefaultMutableTreeNode newTribeNode = new DefaultMutableTreeNode(tribe);
        root.add(newTribeNode);
        return newTribeNode;
    }
}