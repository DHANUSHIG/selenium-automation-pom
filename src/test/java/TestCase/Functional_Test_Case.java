package TestCase;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import Libraries.BaseClass;
import Pages.AddCartPage;
import Pages.CheckoutPage;
import Pages.LoginPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;



public class Functional_Test_Case extends BaseClass {

	@SuppressWarnings("deprecation")
	@Test  
	public void TC_RUn() {
		//Login test case from the LoginPage 
		LoginToApp();
		System.out.println("Login Sucessfully");
		
		//Addtocart test case from the AddCartPage
		AddCartPage ATC=new AddCartPage(driver);
		//Cartview for Checkout test case
		ATC.clikAddcart();
		ATC.viewcart();
		ATC.checkOut();
		System.out.println("Added to cart successfully");
		
		//CheckoutPage test case
		
		CheckoutPage ctbn=new CheckoutPage(driver);
		ctbn.firstname("IG");
		ctbn.lastname("DHANUSH");
		ctbn.zipcode("560037");
		ctbn.cntbnt();
		ctbn.finish();
		
		Assert.assertTrue(isOrderSuccessMessageDisplayed(), "❌ Order success message is NOT displayed!");
		
		}
	public boolean isOrderSuccessMessageDisplayed() {
	    try {
	        WebElement successMessage = driver.findElement(By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']"));
	        System.out.println("THANK YOU FOR YOUR ORDER");
	        return successMessage.isDisplayed();
	        
	    } catch (NoSuchElementException e) {
	        return false;
	    }

	}
}

