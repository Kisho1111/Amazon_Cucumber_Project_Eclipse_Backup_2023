package com.Data_Drivern;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data_Driven_Write {
	
	public static void data_Driven() throws IOException {
		
	File f = new File("C:\\Users\\Kisho\\eclipse-workspace\\Amazon_Cucumber_Project\\Excel\\DataDriven Sheet_Writer.xlsx");
	FileInputStream fis = new FileInputStream(f);
	Workbook w = new XSSFWorkbook(fis);		
		
	Sheet s = w.createSheet("Data");
	Row r = s.createRow(1);
	Cell c = r.createCell(0);
	
	c.setCellValue("Data");//sheetName
	w.getSheet("Data").createRow(2).createCell(2).setCellValue("Kishore");
	
	w.getSheet("Data").createRow(2).createCell(2).setCellValue("Kumar");
	
	FileOutputStream fos = new FileOutputStream(f);
	w.write(fos);
	w.close();
		
}

	public static void main(String[] args) throws IOException {
		
		data_Driven();
	}
}
