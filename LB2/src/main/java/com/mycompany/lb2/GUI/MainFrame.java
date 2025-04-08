package com.mycompany.lb2.GUI;

import com.mycompany.lb2.Ork;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class MainFrame extends JFrame {
    private ArmyTree armyTree;
    private ControlPanel controlPanel;
    private InfoPanel infoPanel;

    public MainFrame() {
        setTitle("Армия Мордора");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        armyTree = new ArmyTree();
        controlPanel = new ControlPanel(armyTree);
        infoPanel = new InfoPanel(armyTree);

        add(new JScrollPane(armyTree.getTree()), BorderLayout.CENTER);
        add(controlPanel.getPanel(), BorderLayout.NORTH);
        add(infoPanel.getPanel(), BorderLayout.EAST);

        armyTree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) armyTree.getLastSelectedNode();
            if (selectedNode != null && selectedNode.getUserObject() instanceof Ork) {
                Ork selectedOrk = (Ork) selectedNode.getUserObject();
                infoPanel.updateInfoPanel(selectedOrk);
            }
        });
    }
}