package TestCase;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTLoginTestCase {
    public WebDriver driver;

    // Setup method to initialize WebDriver and open the website before each test
    @SuppressWarnings("deprecation")
    @BeforeMethod
    public void SetUp() {
        // Set the path to the chromedriver
        System.setProperty("WebDriver.chrome.driver",
                "C:\\Users\\dhanu\\Downloads\\chromedriver-win64\\chromedriver.exe");
        
        // Setup ChromeOptions to handle popups and other browser settings
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); // Disable notifications
        options.addArguments("--disable-popup-blocking"); // Disable popup blocking
        options.addArguments("--disable-geolocation"); // Disable geolocation
        options.addArguments("--incognito"); // Open in incognito mode
        
        // Initialize the WebDriver and open the browser
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Wait for elements to load
        driver.manage().window().maximize(); // Maximize the window
        driver.get("https://www.saucedemo.com/v1/index.html"); // Navigate to the URL
    }

    // Test method to perform login using data from the DataProvider
    @Test(dataProvider = "DP") 
    public void DDTlogin(String data) {
        // Split the data into username and password
        String users[] = data.split(",");
        // Perform login by entering the username and password
        driver.findElement(By.name("user-name")).sendKeys(users[0]);
        driver.findElement(By.name("password")).sendKeys(users[1]);
        driver.findElement(By.id("login-button")).click(); // Click the login button
    }

    // DataProvider method to read login credentials from a JSON file
    @DataProvider(name = "DP") 
    public String[] readjson() throws IOException, ParseException {
        
        // Create a JSONParser object to parse the JSON file
        JSONParser jsonparser = new JSONParser();
        // Print the current working directory (helpful for debugging file paths)
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
        
        // Read the JSON file containing login data
        FileReader reader = new FileReader("JSON-FILE/LoginData.json");

        // Parse the JSON data
        Object obj = jsonparser.parse(reader);
        
        // Cast the parsed object into a JSONObject
        JSONObject userloginjsonobj = (JSONObject) obj;
        
        // Extract the "logins" array from the JSON object
        JSONArray userloginArray = (JSONArray) userloginjsonobj.get("logins");

        // Create an array to store the login credentials as strings (username, password)
        String arr[] = new String[userloginArray.size()];
        System.out.println("Hii IG ");
        
        // Iterate through the "logins" array and retrieve each login data
        for (int i = 0; i < userloginArray.size(); i++) {
            JSONObject users = (JSONObject) userloginArray.get(i);
            // Get username and password from each entry in the JSON array
            String user = (String) users.get("username");
            String pwd = (String) users.get("password");

            // Combine the username and password into a single string and store it in the array
            arr[i] = user + "," + pwd;
        }
        

        // Return the array of login credentials
        return arr;
    }

    // Teardown method to close the browser after the test
    @AfterMethod
    public void tearDown() {
        // Close the browser after all tests are finished
        if (driver != null) {
            driver.quit();
        }
    }
}
