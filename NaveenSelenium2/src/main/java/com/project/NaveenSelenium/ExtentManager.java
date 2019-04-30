package com.project.NaveenSelenium;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	public static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		if(extent==null)
		{
			Date dt = new Date();
			String filename = dt.toString().replace(":", "_").replace(" ", "_")+".html";
//			extent = new ExtentReports("D:\\"+filename);
			extent = new ExtentReports(System.getProperty("user.dir")+"//HtmlReports//"+filename);
//			extent = new ExtentReports("D://extentreport.html");
			extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
			extent.addSystemInfo("Selenium Version","3.8.1").addSystemInfo("Environment","QA");
		}
		return extent;
	}

}
