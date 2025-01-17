package com.sat.testUtil;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtil {

    private Workbook workbook;
    private Sheet sheet;
    private String filePath;

    public ExcelUtil(String filePath) throws IOException {
        this.filePath = filePath;
        FileInputStream fis = new FileInputStream(filePath);
        this.workbook = new XSSFWorkbook(fis);
    }

    public void setSheet(String sheetName) {
        this.sheet = workbook.getSheet(sheetName);
        if (this.sheet == null) {
            this.sheet = workbook.createSheet(sheetName);
        }
    }

    public void setCellValue(int rowNumber, int columnNumber, String value) {
        Row row = sheet.getRow(rowNumber);
        if (row == null) {
            row = sheet.createRow(rowNumber);
        }
        Cell cell = row.getCell(columnNumber);
        if (cell == null) {
            cell = row.createCell(columnNumber);
        }
        cell.setCellValue(""); // Clear the cell value
        cell.setCellValue(value); // Set the new cell value
    }

    public void saveAndClose() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        } finally {
            if (workbook != null) {
                workbook.close();
            }
        }
    }
}