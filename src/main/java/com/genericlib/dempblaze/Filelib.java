package com.genericlib.dempblaze;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Filelib 
{
   String PropPath="TestData/TestData.properties";
	
	public String getDataFromProperties(String key) throws IOException 
	{
		FileInputStream ip = new FileInputStream(PropPath);
		Properties prop = new Properties();
		prop.load(ip);
		return prop.getProperty(key);	
	}
	

/*	public String [][] getDataFromExcel(String path,String sheet) throws Throwable//edit here
	{
		FileInputStream ip = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(ip);
		Sheet sh = wb.getSheet(sheet);//ss model in sheet selecting
		int rows=sh.getLastRowNum(); // write continue after editing
		int cell=sh.getRow(0).getLastCellNum();
		String arr[][]=new String[rows][cell];
		
		for(int i=0; i<rows; i++)  //for total No of rows
		{
			for(int j=0; j<cell; j++)  // for read the column
			{
				arr[i][j]=sh.getRow(i).getCell(j).toString();
			}
		}
		return arr;
	}*/

}
