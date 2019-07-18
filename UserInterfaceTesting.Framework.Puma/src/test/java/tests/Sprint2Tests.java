package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.ErrorConstants;
import constants.PageConstants;
import constants.UserConstants;
import pageactions.Sprint2PageActions;
import pages.BasePage;

public class Sprint2Tests extends BaseTest
{
	@Test
	public void Sprint2Test() 
	{	
		Sprint2PageActions sprint2PageActions = new Sprint2PageActions(Driver);
		GotoSampleApplicationPage(sprint2PageActions.Sprint2Page, PageConstants.Sprint2Url, PageConstants.Sprint2Title);	
		sprint2PageActions.FillOutFormAndSubmit(UserConstants.DefaultFirstName, UserConstants.DefaultLastName);
		ValidatePageTitle(sprint2PageActions.Sprint2Page, ErrorConstants.UltimateQaHomePageError, PageConstants.UltimateQaHomePageTitle);		
	}
		
	private void GotoSampleApplicationPage(BasePage basePage, String url, String title) 
	{
		basePage.goTo(url);
		ValidatePageTitle(basePage, ErrorConstants.SampleApplicationPageError, title);
	}
	
	private void ValidatePageTitle(BasePage basePage, String error, String title) 
	{
		System.out.println(Driver.getTitle());        
		Assert.assertTrue(basePage.IsLoaded(title), error);
	}
}
