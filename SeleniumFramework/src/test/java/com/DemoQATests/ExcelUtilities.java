package com.DemoQATests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtilities {

	private static XSSFWorkbook ExcelBook;
	private static XSSFSheet ExcelSheet;
	private static XSSFCell cell;
	private static XSSFRow row;
	HomePageTest test;
	
	public boolean getExcel(String path, String SheetName)
	
	{
		try {
			System.out.println("Inside getExcel Path-" +path +"Inside getExcel SheetName " +SheetName);
		
			File file = new File(path);
			//File file = new File(path);
			System.out.println("Attempting to read from file in: "+file.getCanonicalPath());
			
			FileInputStream ExcelFile=new FileInputStream(file);
			ExcelBook=new XSSFWorkbook(ExcelFile);
			int index = ExcelBook.getSheetIndex(SheetName);
			if (index == -1) 
			{
				index = ExcelBook.getSheetIndex(SheetName.toUpperCase());
				if (index == -1)
				{
					ExcelFile.close();
					return false;
				}
			
				else
				{
					return true;
				}
			}
			else
			{
				ExcelSheet=ExcelBook.getSheet(SheetName);
				return true;
			}
			
										
		}catch (FileNotFoundException e) {
			
			e.printStackTrace();
			return false;
		} catch (IOException e) {
		
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	
	public String getCellData(int rownum, int colnum)
	{
		
		try {
			 cell= ExcelSheet.getRow(rownum).getCell(colnum);
			 DataFormatter dataformatter= new DataFormatter();
			 String formattedCellData=dataformatter.formatCellValue(cell);
			return formattedCellData;
		} catch (Exception e) {
			
			e.printStackTrace();
			return"";
		}
		
	}
	
	public int getRowCount()
	{
		int rowcount=ExcelSheet.getLastRowNum();
		return rowcount;
	}
	
	public int getColumnCount ()
	{
		
		//ExcelSheet = ExcelBook.getSheet(sheetName);
		row = ExcelSheet.getRow(0);

		if (row == null)
			return -1;
		
		//getLastCellNum- Gets the index of the last cell contained in this row PLUS ONE
		
		return row.getLastCellNum();
	}
	
	
	public void setCellData(int rownum, int colnum, String InputString)
	{
		cell= ExcelSheet.getRow(rownum).getCell(colnum);
		if (cell==null)
		{
			cell=row.createCell(colnum);
			cell.setCellValue(InputString);			
		}
		else
		cell.setCellValue(InputString);
		
	}
	
	public boolean isSheetExist(String SheetName, String path) throws IOException
	{
		FileInputStream ExcelFile=new FileInputStream(path);
		
			ExcelBook=new XSSFWorkbook(ExcelFile);
			int index = ExcelBook.getSheetIndex(SheetName);
			if (index == -1) 
			{
				index = ExcelBook.getSheetIndex(SheetName.toUpperCase());
				if (index == -1)
				{
					ExcelFile.close();
					return false;
				}
			
				else
				{
					ExcelFile.close();
					return true;
				}
			}
			else
				ExcelFile.close();
				return true;
			
		
				}
	
	public Object[][] dataProvider(String path, String SheetName)
	{
		System.out.println("Inside data provider Path-" +path +"Inside data provider SheetName " +SheetName);
								
			if(getExcel(path,SheetName))
			{
				Object[][] data=new Object[getRowCount()+1][getColumnCount()];
				try {
				System.out.println("RowsCount " +getRowCount());
				System.out.println("ColumnsCount " +getColumnCount());
				
				for(int i=0;i<=getRowCount();i++) {
					
					for(int j=0; j<= getColumnCount()-1;j++)
					{
						data[i][j]=getCellData(i,j).toString();
					}
				}
			}
			
			 catch (Exception e) 
				{
					
					e.printStackTrace();
					
				}
				System.out.println("Returning the 2d data object" +data );
			return data;
			}
			return null;
	}
}

	

					
	
	








	/*public  ArrayList<Object> dataProvider(String path, String SheetName)
	{
		System.out.println("Inside data provider Path-" +path +"Inside data provider SheetName " +SheetName);
			ArrayList<Object> dataset=new ArrayList<Object>();
			
			try {
			if(getExcel(path,SheetName))
			{
				for(int i=0;i<=getRowCount();i++) {
					
					
						String UserName= getCellData(i, 0);
						String Password=getCellData(i, 1);
						Object obj[]= {UserName,Password};			
						dataset.add(obj);
						System.out.println("dataprovider Object at " +i +obj.toString());
			}
				
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
			System.out.println("returning dataset from dataprovider method " +dataset);
		return dataset;
			
		
	}*/



