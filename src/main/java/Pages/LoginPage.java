package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Libraries.BaseClass;

public class LoginPage extends BaseClass {
	@FindBy(name="user-name")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(id="login-button")
	WebElement LoginBtn;
	
public LoginPage(WebDriver Driver) {
		
		this.driver=Driver;
		PageFactory.initElements(driver, this);
	}
public void username(String username) {
	Username.sendKeys(username);
}

public void passsword(String passsword) {
	Password.sendKeys(passsword);
}

public void clickLogin() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Explicit wait
    wait.until(ExpectedConditions.elementToBeClickable(LoginBtn));
    LoginBtn.click();
}

	

}
