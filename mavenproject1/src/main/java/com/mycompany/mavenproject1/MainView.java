package com.mycompany.mavenproject1;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;

public class MainView {
    private JFrame frame;
    private JButton importButton;
    private JButton calculateButton;
    private JButton exportButton;
    private JButton exitButton;
    private JLabel statusLabel;

    public MainView() {
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Статистический анализ данных");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10));

        importButton = new JButton("Импорт данных");
        calculateButton = new JButton("Рассчитать показатели");
        exportButton = new JButton("Экспорт данных");
        setExportButtonEnabled(false);
        exitButton = new JButton("Выход");

        buttonPanel.add(importButton);
        buttonPanel.add(calculateButton);
        buttonPanel.add(exportButton);
        buttonPanel.add(exitButton);

        JPanel statusPanel = new JPanel();
        statusLabel = new JLabel("Готов к работе", SwingConstants.CENTER);
        statusPanel.add(statusLabel);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(statusPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void setImportAction(ActionListener listener) {
        importButton.addActionListener(listener);
    }
    
    public void setCalculateAction(ActionListener listener) {
        calculateButton.addActionListener(listener);
    }
    public void setExportAction(ActionListener listener) {
        exportButton.addActionListener(listener);
    }

    public void setExitAction(ActionListener listener) {
        exitButton.addActionListener(listener);
    }

    public File showFileChooser(String title) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(title);
        int result = fileChooser.showOpenDialog(frame);
        return (result == JFileChooser.APPROVE_OPTION) ? fileChooser.getSelectedFile() : null;
    }

    public String showSheetChooser(List<String> sheets) {
        String[] sheetArray = sheets.toArray(new String[0]);
        String selectedSheet = (String) JOptionPane.showInputDialog(
            frame,
            "Выберите лист для импорта данных:",
            "Выбор листа",
            JOptionPane.QUESTION_MESSAGE,
            null,
            sheetArray,
            sheetArray[0]
        );
        return selectedSheet;
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(frame, message, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }

    public void updateStatusLabel(String message) {
        statusLabel.setText(message);
    }
    
     public void showStatisticsWindow(Map<String, Double> statistics) {
        StringBuilder message = new StringBuilder("Рассчитанные показатели:\n");
        for (Map.Entry<String, Double> entry : statistics.entrySet()) {
            message.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        JOptionPane.showMessageDialog(frame, message.toString(), "Рассчитанные показатели", JOptionPane.INFORMATION_MESSAGE);
    }
     
    public void setExportButtonEnabled(boolean enabled) {
        exportButton.setEnabled(enabled);
    }
}
