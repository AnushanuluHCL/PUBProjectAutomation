package com.sat.testUtil;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
}