package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Libraries.BaseClass;

public class AddCartPage extends BaseClass {
	@FindBy(xpath="//div[@class='inventory_list']//div[1]//div[3]//button[1]")
	WebElement AddTOCart;
	
	@FindBy(xpath="//div[@id='shopping_cart_container']/a")
	WebElement ViewCart;
	
	@FindBy(xpath="//div[@class='cart_footer']//a[contains(@class,'btn_action')and contains(@class,'checkout_button')]")
	WebElement CheckOut;
	
	public AddCartPage (WebDriver Driver) {
		this.driver=Driver;
		PageFactory.initElements(driver,this);
	}
	public void clikAddcart() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable( AddTOCart));
		AddTOCart.click();
	}
	
	public void viewcart() {
		WebDriverWait Wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		Wait.until(ExpectedConditions.elementToBeClickable(ViewCart));
		ViewCart.click();
	}
	
	public void checkOut() {
		WebDriverWait wck=new WebDriverWait(driver,Duration.ofSeconds(5));
		wck.until(ExpectedConditions.elementToBeClickable(CheckOut));
		CheckOut.click();
	}
	

}
