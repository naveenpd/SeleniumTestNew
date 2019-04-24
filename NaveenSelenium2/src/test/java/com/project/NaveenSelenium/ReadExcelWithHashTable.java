package com.project.NaveenSelenium;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcelWithHashTable {
	@Test(dataProvider = "getData")
	  public void testA(Hashtable<String, String> data) 
	  {
		if(data.get("Runmode").equals("N"))
			System.out.println(data.get("Runmode")+"---"+data.get("col1")+"---"+data.get("col2")+"---"+data.get("col3")+"---"+data.get("col4"));
	  }
  
  @DataProvider
  public Object[][] getData() throws Exception {
    
	  ExcelAPI e = new ExcelAPI("C:\\Users\\C5270459\\Desktop\\New.xlsx");
		String sheetName = "Data";
		String testCaseName = "TestB";
		
		int testStartRowNum = 0;
		while(!e.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName))
		{
			testStartRowNum++;
		}
		
		System.out.println("Test Starts from row :"+testStartRowNum);
		
		int colStartRowNum = testStartRowNum+1;
		int dataStartRowNum = testStartRowNum+2;
		
		//calculate rows of data
		int rows = 0;
		while(!e.getCellData(sheetName,0,dataStartRowNum+rows).equals(""))
		 {
		    rows++;
		 }
		System.out.println("Total rows are :"+rows);
		
		//calculate cols of data
		
		int cols=0;
		
			while(!e.getCellData(sheetName,cols,colStartRowNum).equals(""))
			{
				cols++;
		    }

		System.out.println("Total cols are :"+cols);
		
		//read the data
		int dataRow =0;
		Object[][] data = new Object[rows][1];
		
		Hashtable<String,String> table = null;
		
		for ( int rNum = dataStartRowNum;rNum<dataStartRowNum+rows;rNum++ )
		{
			table = new Hashtable<String,String>();
			for ( int cNum = 0;cNum<cols;cNum++)
			{
				String key = e.getCellData(sheetName, cNum, colStartRowNum);
				String value = e.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
			}
			data[dataRow][0]=table;
			dataRow++;
		}
		return data;
  }
}
