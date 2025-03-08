package com.mycompany.mavenproject1;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ModelController {
    private FileImporter fileImporter;
    private FileExporter fileExporter;
    private DataStorage dataStorage;
    private StatisticsCalculator statisticsCalculator;
    private Map<String, Double> calculatedStatistics;
    
    private boolean isDataImported = false;
    private boolean isStatisticsCalculated = false;

    public ModelController(String importPath, String exportPath) {
        this.fileImporter = new FileImporter(importPath);
        this.fileExporter = new FileExporter(exportPath);
        this.dataStorage = new DataStorage();
    }

    public void importAndStoreData(File file, String sheetName) throws IOException {
        fileImporter = new FileImporter(file.getAbsolutePath());
        List<List<Double>> samples = fileImporter.importData(sheetName);
        dataStorage.storeData(samples);
        isDataImported = true;
        System.out.println("Данные успешно импортированы и сохранены.");
    }

    public void calculateStatistics() {
        List<List<Double>> samples = dataStorage.getData();
        if (samples.isEmpty()) {
            throw new IllegalStateException("Нет данных для вычислений. Сначала импортируйте данные.");
        }
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(samples);
        calculatedStatistics = statisticsCalculator.calculateAllStatistics();
        dataStorage.storeCalculatedStatistics(calculatedStatistics);
        isStatisticsCalculated = true;
        System.out.println("Показатели успешно рассчитаны.");
    }

    public void exportStatistics(File exportFile) throws IOException {
        if (!isDataImported) {
            throw new IllegalStateException("Нет данных для экспорта. Сначала импортируйте данные.");
        }
        if (!isStatisticsCalculated) {
            throw new IllegalStateException("Нет рассчитанных показателей. Сначала выполните расчет.");
        }
        if (!exportFile.getName().endsWith(".xlsx")) {
            throw new IllegalArgumentException("Неверный формат файла. Ожидался файл формата XLSX.");
        }
        if (fileImporter != null && exportFile.getAbsolutePath().equals(fileImporter.getFilePath())) {
            throw new IllegalArgumentException("Файл для экспорта не должен совпадать с файлом импорта.");
        }
        Map<String, Double> statistics = dataStorage.getCalculatedStatistics();
        if (statistics == null || statistics.isEmpty()) {
            throw new IllegalStateException("Нет рассчитанных показателей. Сначала выполните расчет.");
        }
        fileExporter = new FileExporter(exportFile.getAbsolutePath());
        fileExporter.exportData(statistics);
        System.out.println("Результаты успешно экспортированы.");
    }
 
    public DataStorage getDataStorage() {
        return dataStorage;
    }
    
    public void handleError(String message) {
        System.err.println("Ошибка: " + message);
    }
}
