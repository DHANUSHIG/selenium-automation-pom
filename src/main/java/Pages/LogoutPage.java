package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Libraries.BaseClass;

public class LogoutPage extends BaseClass {
	@FindBy(xpath = "//div[@class='bm-burger-button']")
	WebElement BurgerBtn;

	@FindBy(xpath = "//div[@class='bm-menu']//a[@id='logout_sidebar_link']")
	WebElement LogoutBnt;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickBurgerMenu() {
		BurgerBtn.click();
		
	}
	
	public void clickLogout() {
		LogoutBnt.click();
	}

}
