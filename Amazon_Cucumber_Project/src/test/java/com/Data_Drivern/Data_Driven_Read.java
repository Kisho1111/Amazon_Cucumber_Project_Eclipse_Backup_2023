package com.Data_Drivern;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data_Driven_Read {

	public static void data_Driven() throws IOException {

		File f = new File("C:\\Users\\Kisho\\eclipse-workspace\\Amazon_Cucumber_Project\\Excel\\DataDriven Sheet.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheet("Data");
		Row r = s.getRow(1);
		Cell c = r.getCell(1);
		CellType ct = c.getCellType();

		if (ct.equals(CellType.STRING)) {
			String cellValue = c.getStringCellValue();
			System.out.println(cellValue);
		

		} else if (ct.equals(CellType.NUMERIC)) {
			double d = c.getNumericCellValue();
			int a = (int) d;

		}
		System.out.println("Fetched");
	}
	
	public static void main(String[] args) throws IOException {
		
		data_Driven();
		
	}

}
