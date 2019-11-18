package com.addigy.util;

import com.sun.media.sound.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil {

    public static long PAGE_LOAD_TIMEOUT = 10;
    public static long IMPLICIT_WAIT = 10;
    public static long EXPLICIT_WAIT = 10;

    public static String TEST_DATA_SHEET_PATH = "/Users/pavelaleinik/Library/Mobile Documents/com~apple~CloudDocs/Java/Selenium_projects/addigy/src/main/resources/AddigyTestData.xlsx";

    static Workbook book;
    static Sheet sheet;

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TEST_DATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            try {
                book = WorkbookFactory.create(file);
            } catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
                e.printStackTrace();
            }
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            }
        }
        return data;
    }

}
