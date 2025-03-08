package com.mycompany.mavenproject1;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileImporter {
    private String filePath;

    public FileImporter(String filePath) {
        this.filePath = filePath;
    }
    
    public String getFilePath() {
        return filePath;
    }
    
    public List<List<Double>> importData(String sheetName) throws IOException {
        validateFile();
        List<List<Double>> samples = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Лист не найден: " + sheetName);
            }

            Iterator<Row> rowIterator = sheet.iterator();
            boolean isFirstRow = true;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }

                if (!isRowValid(row)) {
                    continue;
                }

                Iterator<Cell> cellIterator = row.cellIterator();
                int columnIndex = 0;

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    double value = getNumericCellValue(cell);

                    if (samples.size() <= columnIndex) {
                        samples.add(new ArrayList<>());
                    }
                    samples.get(columnIndex).add(value);
                    columnIndex++;
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

    private boolean isRowValid(Row row) {
        for (Cell cell : row) {
            if (cell == null || cell.getCellType() == CellType.BLANK) {
                return false;
            }
            try {
                getNumericCellValue(cell);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return true;
    }
}