package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectModelDemo {
	
	// without PageFinder
	WebDriver driver; 
	
	// constructor
	
	PageObjectModelDemo(WebDriver driver)
	{
		this.driver=driver;
	}
	
	// locators
	
	By username_loc = By.xpath("//input[@placeholder='Username']");
	By password_loc = By.xpath("//input[@placeholder='Password']");
	By button_loc = By.xpath("//button[@type='submit']");
	
	// Action Methods
	
	public void usernameinput(String username)
	{
		driver.findElement(username_loc).sendKeys(username);
	}
	
	public void passwordinput(String password)
	{
		driver.findElement(password_loc).sendKeys(password);
	}
	
	public void clickbutton()
	{
		driver.findElement(button_loc).click();;
	}

}
