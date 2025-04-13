package TestCase;

import org.testng.annotations.Test;

import Libraries.BaseClass;

public class Log_Out_Test_case extends BaseClass {
	@SuppressWarnings("deprecation")
	@Test
	public void VerifyLogout() {
		LoginToApp();
		Logout(); // this method is from BaseClass have written the code there 
		 System.out.println("Login successful");
	}

}

