package com.mycompany.mavenproject1;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileImporter {
    private String filePath;

    public FileImporter(String filePath) {
        this.filePath = filePath;
    }
    
    public String getFilePath() {
        return filePath;
    }
    
    public List<List<Double>> importData(String sheetName) throws Exception {
        validateFile();

        List<List<Double>> samples = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Лист не найден: " + sheetName);
            }

            Row firstRow = sheet.getRow(0);
            int columnCount = firstRow.getLastCellNum();
            for (int i = 0; i < columnCount; i++) {
                samples.add(new ArrayList<>());
            }

            int rowCount = sheet.getLastRowNum();
            for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row == null) {
                    continue;
                }
                for (int colIndex = 0; colIndex < columnCount; colIndex++) {
                    Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    double value = getNumericCellValue(cell);
                    samples.get(colIndex).add(value);
                }
            }
        }

        return samples;
    }

    private void validateFile() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("Файл не найден: " + filePath);
        }
        if (!filePath.endsWith(".xlsx")) {
            throw new IOException("Неверный формат файла. Ожидался файл формата XLSX.");
        }
    }

    private double getNumericCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case NUMERIC:
                return cell.getNumericCellValue();
            case STRING:
                try {
                    return Double.parseDouble(cell.getStringCellValue());
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Некорректное значение в ячейке: " + cell.getAddress());
                }
            default:
                throw new IllegalArgumentException("Неподдерживаемый тип данных в ячейке: " + cell.getAddress());
        }
    }

}