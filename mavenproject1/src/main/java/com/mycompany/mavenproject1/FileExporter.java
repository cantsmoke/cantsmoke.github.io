package com.mycompany.mavenproject1;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class FileExporter {
    private String exportPath;

    public FileExporter(String exportPath) {
        this.exportPath = exportPath;
    }

    public void exportData(Map<String, Double> statistics) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Результат");
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Показатель");
        headerRow.createCell(1).setCellValue("Значение");

        int rowIndex = 1;
        for (Map.Entry<String, Double> entry : statistics.entrySet()) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(entry.getKey());
            row.createCell(1).setCellValue(entry.getValue());
        }

        try (FileOutputStream fos = new FileOutputStream(exportPath)) {
            workbook.write(fos);
        } finally {
            workbook.close();
        }
    }
}
