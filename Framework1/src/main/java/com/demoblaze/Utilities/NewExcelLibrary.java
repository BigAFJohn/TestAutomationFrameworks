package com.demoblaze.Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

public class NewExcelLibrary {
    public static String path;
    public static Workbook workbook;
    public static Sheet sheet;
    public static Row row;
    public static Cell cell;
    
    
    public NewExcelLibrary(String path) {
        this.path = path;
        try {
            FileInputStream fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRowCount(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1)
            return 0;
        else {
            sheet = workbook.getSheetAt(index);
            int number = sheet.getLastRowNum() + 1;
            return number;
        }
    }

    public String getCellData(String sheetName, int colNum, int rowNum) {
        try {
            if (rowNum <= 0)
                return "";

            int index = workbook.getSheetIndex(sheetName);
            if (index == -1)
                return "";

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(rowNum - 1);
            if (row == null)
                return "";
            cell = row.getCell(colNum);

            if (cell == null)
                return "";

            if (cell.getCellType() == CellType.STRING)
                return cell.getStringCellValue();
            else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
                String cellText = String.valueOf(cell.getNumericCellValue());
                if (DateUtil.isCellDateFormatted(cell)) {
                    double d = cell.getNumericCellValue();
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(DateUtil.getJavaDate(d));
                    cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
                    cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cellText;
                }
                return cellText;
            } else if (cell.getCellType() == CellType.BLANK)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());

        } catch (Exception e) {
            e.printStackTrace();
            return "row " + rowNum + " or column " + colNum + " does not exist in xls";
        }
    }

    public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
        try {
            if (rowNum <= 0)
                return false;

            int index = workbook.getSheetIndex(sheetName);
            int colNum = -1;
            if (index == -1)
                return false;

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(0);
            for (int i = 0; i < row.getLastCellNum(); i++) {
                if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
                    colNum = i;
                    break;
                }
            }

            if (colNum == -1)
                return false;

            sheet.autoSizeColumn(colNum);
            row = sheet.getRow(rowNum - 1);
            if (row == null)
                row = sheet.createRow(rowNum - 1);

            cell = row.getCell(colNum);
            if (cell == null)
                cell = row.createCell(colNum);

            cell.setCellValue(data);

            try (FileOutputStream fileOut = new FileOutputStream(path)) {
                workbook.write(fileOut);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getColumnCount(String sheetName){
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(0);
        if (row == null)
            return -1;
        return row.getLastCellNum();
    }

}
