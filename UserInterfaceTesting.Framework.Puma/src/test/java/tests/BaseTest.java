package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import constants.UserConstants;
import resources.User;
import resources.WebDriverFactory;

public class BaseTest 
{
    WebDriver Driver;
    
    User TestUser;

    @BeforeMethod
    public void SetupBeforeEveryTest()
    {
        Driver = WebDriverFactory.GetChromeDriver();
        TestUser = new User(UserConstants.DefaultFirstName, UserConstants.DefaultLastName);
    }	
    
    @AfterMethod
    public void SetupAfterEveryTest()
    {
		Driver.close();
		Driver.quit();		
    }
}