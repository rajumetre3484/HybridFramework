package com.genericlib.dempblaze;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.objectrepo.demoblaze.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;// make static for single browser launching
	public Filelib fl = new Filelib();
	public CommonUtils cu = new CommonUtils();
	public static HomePage hp;
	public static String ProductName;

	public static ExtentReports report;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;

	// @org.testng.annotations.Parameters("browser") //for @parameters for the
	// parallel executions for the test cases>>> required for only parallel
	// execution
//	@BeforeTest  //or @BeforeSuite 
	// public void configBS(String bn) throws IOException, InterruptedException :
	// for when using parallel execution is requred.
	/*
	 * public void configBS(String bn) throws IOException, InterruptedException {
	 * if(bn.equals("firefox"))
	 * //if(fl.getDataFromProperties("browser").equals("firefox")); this remove bcz
	 * of the parallel execution. { WebDriverManager.firefoxdriver().setup();
	 * driver=new FirefoxDriver(); }
	 * 
	 * if(bn.equals("edge")) { WebDriverManager.edgedriver().setup(); driver=new
	 * EdgeDriver(); }
	 */

	/*
	 * @Parameters("browser")
	 * 
	 * @BeforeTest //for parallel public void configBS(String bn) throws
	 * IOException, InterruptedException if(bn.equals("firefox"))
	 */

	@BeforeTest(groups = { "smoke", "regression" })
	public void configBS() throws IOException, InterruptedException {
		report = new ExtentReports();
		spark = new ExtentSparkReporter("Demoblaze.html"); // extent report is available with name
		report.attachReporter(spark);// folder is available

		if (fl.getDataFromProperties("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		WebDriverManager.edgedriver().setup();
		if (fl.getDataFromProperties("browser").equals("edge")) {

			driver = new EdgeDriver();
		}

		driver.get(fl.getDataFromProperties("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Reporter.log("Launched the browser", true);
		Thread.sleep(3000);
	}

	@BeforeMethod(groups = { "smoke", "regression" })
	public void configBM() throws IOException, InterruptedException {
		hp = PageFactory.initElements(driver, HomePage.class);
		Thread.sleep(3000);
		hp.getLogin1().click();
		Thread.sleep(3000);
		hp.getLoginusername().sendKeys(fl.getDataFromProperties("username"));
		hp.getLoginpassword().sendKeys(fl.getDataFromProperties("password"));
		hp.getLoginButton2().click();
		// Thread.sleep(5000);
		cu.resolveStaleElement(hp.getNameOfTheUser());
		// System.out.println(hp.getNameOfTheUser().getText());
		// Assert.assertTrue(hp.getNameOfTheUser().getText().contains(fl.getDataFromProperties("username")));
		Assert.assertEquals(driver.getTitle(), "STORE");
		Reporter.log("Loggin to the app", true);

	}

	@AfterMethod(groups = { "smoke", "regression" })
	public void configAM() throws InterruptedException {
		hp.getLogout().click();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getTitle(), "STORE");
		Reporter.log("Logged out from the app", true);
		test.pass("Logged out from the app");

	}

	@AfterTest(groups = { "smoke", "regression" }) // or @AfterSuite
	public void configAS() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		Reporter.log("closed the broowser", true);
		test.pass("Close the browser");
		report.flush();

	}

}
