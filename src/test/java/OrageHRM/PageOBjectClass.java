package OrageHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageOBjectClass {
	
	//without pagefactory class
	WebDriver driver;
	//constructor
	PageOBjectClass(WebDriver driver)
	{
		this.driver=driver;	
	}

	//locators
	
	By username_loc = By.xpath("//input[@placeholder='Username']");
    By password_loc = By.xpath("//input[@placeholder='Password']");
    By button_loc = By.xpath("//button[normalize-space()='Login']");
    By logo_loc = By.xpath("//img[@alt='client brand banner']");
    
    // Action Methods
    
    public void inputusername(String name)
    {
    	driver.findElement(username_loc).sendKeys(name);
    }
    
    public void inputpassword(String password)
    {
    	driver.findElement(password_loc).sendKeys(password);
    }
    
    public void clickbutton()
    {
    	driver.findElement(button_loc).click();
    }
    
    public boolean logodisplay()
    {
    	boolean status = driver.findElement(logo_loc).isDisplayed();
    	return status;
    	
    }
    
	
}
