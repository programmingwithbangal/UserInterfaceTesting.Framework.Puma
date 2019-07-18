package tests;

import pageactions.Sprint3PageActions;
import pages.BasePage;
import resources.Gender;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.ErrorConstants;
import constants.PageConstants;

public class Sprint3Tests extends BaseTest
{
	@Test
	public void Sprint3TestFemale() throws Exception
	{	
		Sprint3PageActions sprint3PageActions = new Sprint3PageActions(Driver);
		GotoSampleApplicationPage(sprint3PageActions.Sprint3Page, PageConstants.Sprint3Url, PageConstants.Sprint3Title);	
		SetGenderType(Gender.Female);
		sprint3PageActions.FillOutFormWithRadioButtonAndSubmit(TestUser);
		ValidatePageTitle(sprint3PageActions.Sprint3Page, ErrorConstants.UltimateQaHomePageError, PageConstants.UltimateQaHomePageTitle);		
	}
	
	@Test
	public void Sprint3TestOther() throws Exception
	{	
		Sprint3PageActions sprint3PageActions = new Sprint3PageActions(Driver);
		GotoSampleApplicationPage(sprint3PageActions.Sprint3Page, PageConstants.Sprint3Url, PageConstants.Sprint3Title);	
		SetGenderType(Gender.Other);
		sprint3PageActions.FillOutFormWithRadioButtonAndSubmit(TestUser);
		ValidatePageTitle(sprint3PageActions.Sprint3Page, ErrorConstants.UltimateQaHomePageError, PageConstants.UltimateQaHomePageTitle);		
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
	
	private void SetGenderType(Gender genderType) 
	{ 
		TestUser.setGenderType(genderType);
	}
}