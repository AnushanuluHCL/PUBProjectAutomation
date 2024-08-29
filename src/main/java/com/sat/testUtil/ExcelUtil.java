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
        cell.setCellValue(value);
    }

    public void saveAndClose() throws IOException {
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        fos.close();
        workbook.close();
    }
}

/*
public class ExcelUtil {

    private static final String TEST_DATA_SHEET_PATH = "./src/test/resources/testdata/OpenCartTestData.xlsx";
    private static Workbook book;
    private static Sheet sheet;

    public List<String[]> getRowData(String sheetName, String columnName) {
        System.out.println("Reading test data from sheet: " + sheetName + " for column: " + columnName);

        List<String[]> cellDataList = new ArrayList<>();

        try {
            FileInputStream ip = new FileInputStream(new File(TEST_DATA_SHEET_PATH));
            book = new XSSFWorkbook(ip);
            sheet = book.getSheet(sheetName);

            Row headerRow = sheet.getRow(0);
            int cellIndex = -1;
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                Cell headerCell = headerRow.getCell(i);
                if (headerCell != null && headerCell.toString().equals(columnName)) {
                    cellIndex = i;
                    break;
                }
            }

            if (cellIndex != -1) {
                int rowCount = sheet.getLastRowNum();
                for (int i = 1; i <= rowCount; i++) {
                    Row row = sheet.getRow(i);
                    Cell cell = row.getCell(cellIndex);
                    if (cell != null) {
                        String cellValue = cell.toString();
                        String[] splitData = cellValue.split(";");
                        cellDataList.add(splitData);
                    }
                }
            }

            ip.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cellDataList;
    }
}*/
