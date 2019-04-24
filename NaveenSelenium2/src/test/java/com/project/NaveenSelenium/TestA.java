package com.project.NaveenSelenium;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class TestA {
  @Test(dataProvider = "getData")
  public void testA(String Runmode,String col1,String col2,String col3,String col4) 
  {
  }

  @DataProvider
  public Object[][] getData() throws Exception {
    
	  ExcelAPI e = new ExcelAPI("C:\\Users\\C5270459\\Desktop\\sampleData.xlsx");
		String sheetName = "Read";
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
		Object[][] data = new Object[rows][cols];
		
		for ( int rNum = dataStartRowNum;rNum<dataStartRowNum+rows;rNum++ )
		{
			for ( int cNum = 0;cNum<cols;cNum++)
			{
				data[dataRow][cNum]=e.getCellData(sheetName, cNum, rNum);
			}
			dataRow++;
		}
		return data;
  }
}
