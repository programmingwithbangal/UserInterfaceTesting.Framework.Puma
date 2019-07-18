package tests;

import pageactions.Sprint1PageActions;
import pages.BasePage;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.ErrorConstants;
import constants.PageConstants;
import constants.UserConstants;

public class Sprint1Tests extends BaseTest
{	
	@Test
	public void Sprint1Test() 
	{
		Sprint1PageActions sprint1PageActions = new Sprint1PageActions(Driver);
		GotoSampleApplicationPage(sprint1PageActions.Sprint1Page, PageConstants.Sprint1Url, PageConstants.Sprint1Title);
		sprint1PageActions.FillOutFormAndSubmit(UserConstants.DefaultFirstName);
		ValidatePageTitle(sprint1PageActions.Sprint1Page, ErrorConstants.UltimateQaHomePageError, PageConstants.UltimateQaHomePageTitle);
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