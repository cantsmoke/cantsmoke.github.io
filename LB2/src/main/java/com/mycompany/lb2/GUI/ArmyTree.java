package com.mycompany.lb2.GUI;

import com.mycompany.lb2.Ork;
import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class ArmyTree {
    private JTree tree;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode root;

    public ArmyTree() {
        root = new DefaultMutableTreeNode("Армия Мордора");
        treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);
    }

    public void addOrkToTree(Ork ork, String tribe) {
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

    public DefaultMutableTreeNode getLastSelectedNode() {
        return (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
    }

    public void addTreeSelectionListener(TreeSelectionListener listener) {
        tree.addTreeSelectionListener(listener);
    }

    public JTree getTree() {
        return tree;
    }
}
