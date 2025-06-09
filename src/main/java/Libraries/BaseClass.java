package Libraries;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.LogoutPage;

public class BaseClass {
	public WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void SetUp() {
		System.setProperty("WebDriver.chrome.driver",
				"C:\\Users\\dhanu\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		// Step 2: Add arguments to handle popups
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-geolocation");
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/index.html");
	}

	public void LoginToApp() {
		LoginPage LP = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		LP.username("standard_user");
		LP.passsword("secret_sauce");
		LP.clickLogin();
		
	}
	
	public void Logout() {
		LogoutPage LT=new LogoutPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LT.clickBurgerMenu();
		LT.clickLogout();
	}
	
	  @AfterMethod public void Quit() { if(driver!=null) { driver.quit(); } }
	 

}
