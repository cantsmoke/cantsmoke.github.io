package com.mycompany.mavenproject1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.Map;

public class MainController {
    private MainView mainView;
    private ModelController modelController;

    public MainController(MainView mainView, ModelController modelController) {
        this.mainView = mainView;
        this.modelController = modelController;

        mainView.setImportAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleImportAction();
            }
        });

        mainView.setCalculateAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCalculateAction();
            }
        });

        mainView.setExportAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleExportAction();
            }
        });

        mainView.setExitAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleExitAction();
            }
        });
    }

    private void handleImportAction() {
        try {
            File importFile = mainView.showFileChooser("Выберите файл для импорта");
            if (importFile == null) {
                return;
            }

            List<String> sheetNames = getSheetNames(importFile);
            if (sheetNames.isEmpty()) {
                mainView.showErrorMessage("Файл не содержит листов.");
                return;
            }

            String selectedSheet = mainView.showSheetChooser(sheetNames);
            if (selectedSheet == null) {
                return;
            }
            modelController.importAndStoreData(importFile, selectedSheet);
            mainView.updateStatusLabel("Данные успешно импортированы.");
        } catch (Exception ex) {
            mainView.showErrorMessage("Ошибка при импорте данных: " + ex.getMessage());
        }
    }

    private void handleExportAction() {
        try {
            File exportFile = mainView.showFileChooser("Выберите файл для экспорта");
            if (exportFile == null) {
                return;
            }

            modelController.exportStatistics(exportFile);
            mainView.updateStatusLabel("Результаты успешно экспортированы.");
        } catch (Exception ex) {
            mainView.showErrorMessage("Ошибка при экспорте данных: " + ex.getMessage());
        }
    }

    private void handleExitAction() {
        System.exit(0);
    }

    private List<String> getSheetNames(File file) throws Exception {
        try (var fis = new java.io.FileInputStream(file);
             var workbook = new org.apache.poi.xssf.usermodel.XSSFWorkbook(fis)) {
            List<String> sheetNames = new java.util.ArrayList<>();
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                sheetNames.add(workbook.getSheetName(i));
            }
            return sheetNames;
        }
    }
    
    private void handleCalculateAction() {
        try {
            modelController.calculateStatistics();
            Map<String, Double> statistics = modelController.getDataStorage().getCalculatedStatistics();
            mainView.showStatisticsWindow(statistics);
            mainView.updateStatusLabel("Показатели успешно рассчитаны.");
            mainView.setExportButtonEnabled(true);
        } catch (Exception ex) {
            mainView.showErrorMessage("Ошибка при расчете показателей: " + ex.getMessage());
        }
    }
}
