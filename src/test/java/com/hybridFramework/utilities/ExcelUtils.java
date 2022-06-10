package com.hybridFramework.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static XSSFWorkbook wb;
	public static XSSFSheet wbsheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileInputStream fis;
	
	
	public static int rowCount(String excelpath, String sheet) throws IOException
	{
		//File f=new File(excelpath);
		fis=new FileInputStream(excelpath);
		wb=new XSSFWorkbook(fis);
		wbsheet=wb.getSheet(sheet);
		int rowCount=wbsheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
			
	}

	public static int cellCount(String excelpath, String sheet, int rowNum) throws IOException
	{
		fis=new FileInputStream(excelpath);
		wb=new XSSFWorkbook(fis);
		wbsheet=wb.getSheet(sheet);
		row=wbsheet.getRow(rowNum);
		int cellCount=row.getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;
			
	}
	
	public static String getCellData(String excelpath, String sheet, int rowNum, int cellCount) throws IOException
	{
		fis=new FileInputStream(excelpath);
		wb=new XSSFWorkbook(fis);
		wbsheet=wb.getSheet(sheet);
		row=wbsheet.getRow(rowNum);
		cell=row.getCell(cellCount);
		//String value;
		//value=row.getCell(cellCount).getStringCellValue();
//		if(row.getCell(cellCount).getCellType()==CellType.NUMERIC)
//		{
//			value=row.getCell(cellCount).getNumericCellValue();
//		}
//		else
//		{
//			value=row.getCell(cellCount).getStringCellValue();
//		}
		DataFormatter formatter=new DataFormatter();// It returns the value as String regardless of the cell data type 
		String cellData=formatter.formatCellValue(cell);
		wb.close();
		fis.close();
		return cellData;
		
		
		
		
	}
			

}
