package pageactions;

import org.openqa.selenium.WebDriver;

import pages.Sprint5Page;
import resources.User;

public class Sprint5PageActions 
{
	public Sprint5Page Sprint5Page;
	
    public Sprint5PageActions(WebDriver driver)
    {
    	Sprint5Page = new Sprint5Page(driver);
    }
    
    public void FillOutPrimaryContactForm(User user) throws Exception
    {
    	SetPrimaryContactGender(user);
    	Sprint5Page.getFirstNameField().sendKeys(user.getFirstName());
    	Sprint5Page.getLastNameField().sendKeys(user.getLastName());
    }
    
    public void FillOutEmergencyContactFormAndSubmit(User emergencyContactUser) throws Exception
    {
    	SetEmergencyContactGender(emergencyContactUser);
    	Sprint5Page.getFirstNameEmergencyContactField().sendKeys(emergencyContactUser.getFirstName());
    	Sprint5Page.getLastNameEmergencyContactField().sendKeys(emergencyContactUser.getLastName());
        Sprint5Page.getSubmitButton().submit();
    }

    
    private void SetPrimaryContactGender(User user) throws Exception
    {
        switch (user.getGenderType())
        {
            case Male:
                break;
            case Female:
                Sprint5Page.getFemaleGenderRadioButton().click();
                break;
            case Other:
            	Sprint5Page.getOtherGenderRadioButton().click();
                break;
            case None:
                throw new Exception("Request type: None is invalid.");
            default:
                throw new UnsupportedOperationException("Request type is not supported.");
        }
    }
    
    private void SetEmergencyContactGender(User emergencyContactUser) throws Exception
    {
        switch (emergencyContactUser.getGenderType())
        {
            case Male:
                break;
            case Female:
                Sprint5Page.getFemaleGenderEmergencyContactRadioButton().click();
                break;
            case Other:
            	Sprint5Page.getOtherGenderEmergencyContactRadioButton().click();
                break;
            case None:
                throw new Exception("Request type: None is invalid.");
            default:
                throw new UnsupportedOperationException("Request type is not supported.");
        }
    }
}