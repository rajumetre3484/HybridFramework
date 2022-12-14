package com.testscript.demoblaze;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlib.dempblaze.Base;
import com.genericlib.dempblaze.EventList;
import com.objectrepo.demoblaze.HomePage;

@Listeners(EventList.class)
public class AddToCart extends Base
{
	@Test (groups={"smoke"})
	public void addToCartTest() throws InterruptedException, IOException
	{
		test=report.createTest("validate product can be added to the cart");
		test.pass("logged into the app as"+fl.getDataFromProperties("username"));
		 hp=PageFactory.initElements(driver, HomePage.class);
		 test.pass("Landed on the Home page");
		 
		ProductName=hp.getNexus6().getText();
		Thread.sleep(3000);
		hp.getNexus6().click();
		test.pass("Clicked on Nexus6 product");
		test.pass("Navigated to product details page");
		
		hp.getAddToCart().click();
		Thread.sleep(4000);
		test.pass("Clicked on add product details");
		
		Reporter.log("Product to be added");
        cu.acceptAlert(driver);
        test.pass("handeled Alert");
     
        hp.getCart().click();
        Thread.sleep(3000);
        Assert.assertTrue(cu.VerifyProductInCart(ProductName, driver).isDisplayed());
        test.pass("Verify the product in the Cart");
       
	}
}
