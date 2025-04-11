package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Libraries.BaseClass;

public class CheckoutPage extends BaseClass{
      @FindBy(xpath="//input[@id='first-name']")
      WebElement Firstname;
      
      @FindBy(xpath="//input[@id='last-name']")
      WebElement Lastname;
      
      @FindBy(xpath="//input[@id='postal-code']")
      WebElement Zipcode;
      
      @FindBy(xpath="//div[@class='checkout_buttons']/input[@class='btn_primary cart_button']")
      WebElement Continuebnt;
      
      @FindBy(xpath="//div[@class='cart_footer']/a[@class='btn_action cart_button']")
      WebElement Finish;
      
      public CheckoutPage(WebDriver Driver) {
  		
  		this.driver=Driver;
  		PageFactory.initElements(driver, this);
  	}
      public void firstname(String Fname) {
    	  Firstname.sendKeys(Fname);
      }
      public void lastname(String Lname) {
    	  Lastname.sendKeys(Lname);
      }
      public void zipcode(String code) {
    	  Zipcode.sendKeys(code);
      }
      public void cntbnt() {
    	  WebDriverWait Cwait=new WebDriverWait(driver,Duration.ofSeconds(5));
    	  Cwait.until(ExpectedConditions.elementToBeClickable(Continuebnt));
    	  Continuebnt.click();
      }
      public void finish() {
    	  WebDriverWait Fwait=new WebDriverWait(driver,Duration.ofSeconds(5));
    	  Fwait.until(ExpectedConditions.elementToBeClickable(Finish));
    	  Finish.click();
      }
}
