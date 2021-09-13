package com.guru99.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	
	public static  String TEST_DATA_SHEET_PATH ="C:\\Users\\mshah\\javaproject\\Guru99_BankingProject\\src\\main\\java\\com\\guru99\\testData\\Testdata_guru99.xlsx";
	public static Workbook book;
	public static Sheet sheet;
	
	public static Object[][] getTestData(String Sheetname) {
		
		try {
			FileInputStream fi=new FileInputStream(TEST_DATA_SHEET_PATH);
			book = WorkbookFactory.create(fi);
			sheet = book.getSheet(Sheetname);
			
			Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0; i<sheet.getLastRowNum(); i++) {
				for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
					
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
				
			}
			
			return data;
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
