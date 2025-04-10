package com.testng.qa.utility;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelReader {

    public static Iterator<Object[]> readExcelData(String filePath, String ssName) {
        List<Map<String, Object>> dataList = new ArrayList<>();
        System.out.println("File: " + filePath);
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheet(ssName);
            Row headerRow = sheet.getRow(0);
            int numColumns = headerRow.getLastCellNum();

            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row currentRow = sheet.getRow(rowNum);
                if (currentRow == null) continue;
                Map<String, Object> rowData = new LinkedHashMap<>();
                for (int colNum = 0; colNum < numColumns; colNum++) {
                    Cell currentCell = currentRow.getCell(colNum);
                    if (currentCell == null) continue;
                    String columnHeader = headerRow.getCell(colNum).getStringCellValue();
                    rowData.put(columnHeader, getCellData((XSSFCell) currentCell));
                }
                dataList.add(rowData);
            }
            workbook.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.getMessage();
        }
        Collection<Object[]> dp = new ArrayList<Object[]>();
        for (Map<String,Object> m:dataList) {
            dp.add(new Object[]{m});
        }
        return dp.iterator();
    }

    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;

    public static Object[][] getTableArray(String FilePath, String SheetName) {
        System.out.println("File: " + FilePath);
        System.out.println("Sheet: " + SheetName);
        Object[][] tabArray = null;
        try {
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
            int startRow = 1;
            int startCol = 1;
            int ci, cj;
            int totalRows = ExcelWSheet.getLastRowNum();
            // you can write a function as well to get Column count
            int totalCols = 2;
            tabArray = new Object[totalRows][totalCols];
            ci = 0;
            for (int i = startRow; i <= totalRows; i++, ci++) {
                cj = 0;
                for (int j = startCol; j <= totalCols; j++, cj++) {
                    Cell = ExcelWSheet.getRow(i).getCell(j);
                    tabArray[ci][cj] = getCellData(Cell);
                    System.out.println(tabArray[ci][cj]);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return (tabArray);
    }

    public static Object getCellData(XSSFCell c) {
        Object cellValue = null;
        try {
            if (c != null) {
                switch (c.getCellType()) {
                    case STRING:
                        cellValue = c.getStringCellValue();
                        break;
                    case NUMERIC:
                        //cellValue = String.valueOf(currentCell.getNumericCellValue());
                        cellValue = c.getNumericCellValue();
                        break;
                    case BOOLEAN:
                        //cellValue = String.valueOf(currentCell.getBooleanCellValue());
                        cellValue = c.getBooleanCellValue();
                        break;
                    case FORMULA:
                        cellValue = c.getCellFormula();
                        break;
                    case BLANK:
                        cellValue = "";
                        break;
                    default:
                        cellValue = "";
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cellValue;
    }
}
