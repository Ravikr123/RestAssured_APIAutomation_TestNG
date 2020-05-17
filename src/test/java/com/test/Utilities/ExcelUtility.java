package com.test.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		
		fi= new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int total_rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return total_rowCount;
		
	}
	
	public static int getCellCount(String xlfile, String xlsheet, int rowNum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		int total_cellCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return total_cellCount;
	}
	
	
	public static String getCellData(String xlfile, String xlsheet, int rowNum, int colNum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);
		DataFormatter formatter = new DataFormatter();
		String cellData = formatter.formatCellValue(cell);
		wb.close();
		fi.close();
		return cellData;
		
	}
	
	public static void setCellData(String xlfile, String xlsheet, int rowNum, int colNum, String data) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		cell=row.createCell(colNum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}
	

}
