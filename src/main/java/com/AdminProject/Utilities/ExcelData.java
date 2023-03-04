package com.AdminProject.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	public static String getData(int i, int j) throws IOException {
		File source = new File ("C:\\Users\\Ritessh\\Desktop\\test.xlsx");
		FileInputStream inputstream = new FileInputStream (source);
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(inputstream);
		XSSFSheet sheet =wb.getSheet("table");
		XSSFRow row = sheet.getRow(i);
		XSSFCell cell = row.getCell(j);
		String data =cell.getStringCellValue();
		return data;
	}

}
