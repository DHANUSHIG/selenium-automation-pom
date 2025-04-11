package TestCase;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import Libraries.BaseClass;
import Pages.LoginPage;

public class LoginTestCase extends BaseClass {
	@SuppressWarnings("deprecation")
	@Test
	public void VerifyLogin() {
		LoginToApp(); // this method is from BaseClass have written the code there 
		 System.out.println("Login successful");
	}

}