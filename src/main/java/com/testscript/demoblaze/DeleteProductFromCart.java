package com.testscript.demoblaze;

import java.util.NoSuchElementException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlib.dempblaze.EventList;
import com.objectrepo.demoblaze.HomePage;
@Listeners(EventList.class)
public class DeleteProductFromCart extends com.genericlib.dempblaze.Base
{
	@Test (groups={"regression"})
	public void deleteProductFromCartTest() throws InterruptedException
	{
		hp=PageFactory.initElements(driver, HomePage.class);
		test=report.createTest("validate deletion of a product from the cart");
		test.pass("Landed on the Home page");
	
		
		hp.getCart().click();
		test.pass("Clicked on Cart");
		test.pass("Landed on the cart page");
		cu.deleteProduct(ProductName, driver).click();
		Thread.sleep(5000);
		test.pass("Clicked on Delete button of the product");
	
		try  
		{
			cu.VerifyProductInCart(ProductName,driver);
		    Assert.assertTrue(false, "Product has not been deleted-Test failed");   //Assert.assertEquals(driver.getCurrentUrl(), "https://www.demoblaze.com/cart.html#");
		}
		
		catch (NoSuchElementException n)
		{
			Reporter.log("DELETED"+ProductName+"from cart");
		}
		test.pass("Product deletion has been varified");
	}
}
