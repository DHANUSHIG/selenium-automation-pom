package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By inventory = By.className("inventory_list");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isInventoryVisible() {
        return driver.findElement(inventory).isDisplayed();
    }
}
