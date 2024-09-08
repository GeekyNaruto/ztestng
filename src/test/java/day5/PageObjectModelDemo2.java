package day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectModelDemo2 {
	
	// without PageFinder
	WebDriver driver; 
	
	// constructor
	
	PageObjectModelDemo2(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// locators
	
	@FindBy(xpath = "//input[@placeholder='Username']") WebElement username_loc ;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement password_loc ;
	@FindBy(xpath="//button[@type='submit']") WebElement button_loc ;
	
	// Action Methods
	
	public void usernameinput(String username)
	{
		username_loc.sendKeys(username);
	}
	
	public void passwordinput(String password)
	{
		password_loc.sendKeys(password);
	}
	
	public void clickbutton()
	{
		button_loc.click();;
	}

}
