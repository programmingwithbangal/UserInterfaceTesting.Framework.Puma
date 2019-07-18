package tests;

import pageactions.Sprint4PageActions;
import pages.BasePage;
import resources.Gender;
import resources.User;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.ErrorConstants;
import constants.PageConstants;
import constants.UserConstants;

public class Sprint4Tests extends BaseTest
{
	@Test
	public void Sprint4TestFemale() throws Exception
	{	
		Sprint4PageActions sprint4PageActions = new Sprint4PageActions(Driver);
		GotoSampleApplicationPage(sprint4PageActions.Sprint4Page, PageConstants.Sprint4Url, PageConstants.Sprint4Title);	
		SetGenderType(Gender.Female);
		sprint4PageActions.FillOutPrimaryContactForm(TestUser);
		User TestEmergencyContactUser = new User(UserConstants.EmergencyContactFirstName, UserConstants.EmergencyContactLastName, Gender.Female);
        sprint4PageActions.FillOutEmergencyContactFormAndSubmit(TestEmergencyContactUser);
		ValidatePageTitle(sprint4PageActions.Sprint4Page, ErrorConstants.UltimateQaHomePageError, PageConstants.UltimateQaHomePageTitle);		
	}
	
	@Test
	public void Sprint4TestOther() throws Exception
	{	
		Sprint4PageActions sprint4PageActions = new Sprint4PageActions(Driver);
		GotoSampleApplicationPage(sprint4PageActions.Sprint4Page, PageConstants.Sprint4Url, PageConstants.Sprint4Title);	
		SetGenderType(Gender.Other);
		sprint4PageActions.FillOutPrimaryContactForm(TestUser);
		User TestEmergencyContactUser = new User(UserConstants.EmergencyContactFirstName, UserConstants.EmergencyContactLastName, Gender.Other);
        sprint4PageActions.FillOutEmergencyContactFormAndSubmit(TestEmergencyContactUser);
		ValidatePageTitle(sprint4PageActions.Sprint4Page, ErrorConstants.UltimateQaHomePageError, PageConstants.UltimateQaHomePageTitle);		
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