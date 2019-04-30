package com.project.NaveenSelenium;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;

import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class TC_007 extends BasePage{
	public static final Logger log = Logger.getLogger(TC_007.class.getName());
	SoftAssert softAssert = new SoftAssert();
	PageUI page;

  @BeforeMethod
  public void startprocess() throws Exception {
	  //generate the extent report
	  test= rep.startTest("TC_007");
	  test.log(LogStatus.INFO, "Starting the testcase TC_007");
	  Reporter.log("Starting the testcase TC_007");
	  openBrowser("chromebrowser");
	  test.log(LogStatus.INFO, "Opening the chrome browser");
	  navigate("automationurl");
	  test.log(LogStatus.INFO, "Enter the url with --"+loadData("automationurl") );
	  
  }
  
  @Test(enabled=false)
  public void automationLogin() {
	 
	  page = new PageUI(driver);
	  page.login();
//	  Assert.assertEquals(page.verifyError(), "Authentication failed.");

  }
  @Test
  public void automationRegistration() throws Exception {
	  
	  page = new PageUI(driver);
	  page.customerRegistration();
	  test.log(LogStatus.PASS, "Testcase TC_007 got Passed");
	  
  }

  @AfterMethod
  public void endprocess() 
  {
	  try {
		  softAssert.assertAll();
	  }catch(Error e) {
		  test.log(LogStatus.FAIL, e.getMessage());
	  }
	  extent.endTest(test);
	  extent.flush();
	  if(driver!=null) {
		  driver.quit();
	  }
  }

}
