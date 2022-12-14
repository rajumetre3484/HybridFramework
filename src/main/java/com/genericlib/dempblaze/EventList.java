package com.genericlib.dempblaze;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;

public class EventList implements ITestListener
{
	public void onTestFailure(ITestResult result)
	{
		

	File src= ((TakesScreenshot)Base.driver).getScreenshotAs(OutputType.FILE);
       File dest=new File("/Screenshot/"+System.currentTimeMillis()+".PNG");
         String path=dest.getAbsolutePath();
       
       try 
       {
		FileUtils.copyFile(src, dest);
	   } 
       catch (IOException e)
       {
		e.printStackTrace();
	  }
          Base.test.fail("Test script failed "+result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());// for attaching sc to the ExtentReport
		
		
	}


}
