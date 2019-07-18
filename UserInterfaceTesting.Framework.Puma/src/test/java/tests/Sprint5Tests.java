package tests;

import pageactions.Sprint5Page2Actions;
import pageactions.Sprint5PageActions;
import pages.BasePage;
import resources.Animal;
import resources.Gender;
import resources.User;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.ErrorConstants;
import constants.PageConstants;
import constants.UserConstants;

public class Sprint5Tests extends BaseTest
{
	@Test
	public void Sprint5TestFemale() throws Exception
	{	
		Sprint5PageActions sprint5PageActions = new Sprint5PageActions(Driver);
		GotoSampleApplicationPage(sprint5PageActions.Sprint5Page, PageConstants.Sprint5Url, PageConstants.Sprint5Title);	
		SetGenderType(Gender.Female);
		sprint5PageActions.FillOutPrimaryContactForm(TestUser);
		User TestEmergencyContactUser = new User(UserConstants.EmergencyContactFirstName, UserConstants.EmergencyContactLastName, Gender.Female);
        sprint5PageActions.FillOutEmergencyContactFormAndSubmit(TestEmergencyContactUser);
		ValidatePageTitle(sprint5PageActions.Sprint5Page, ErrorConstants.SampleApplicationPage2Error, PageConstants.FormPage2Title);		
		Sprint5Page2Actions sprint5Page2Actions = new Sprint5Page2Actions(Driver);
		sprint5Page2Actions.FillOutRadioButtonAndSubmit(Animal.Crocodiles);
		ValidatePageTitle(sprint5PageActions.Sprint5Page, ErrorConstants.UltimateQaHomePageError, PageConstants.UltimateQaHomePageTitle);			
	}
	
	@Test
	public void Sprint5TestOther() throws Exception
	{	
		Sprint5PageActions sprint5PageActions = new Sprint5PageActions(Driver);
		GotoSampleApplicationPage(sprint5PageActions.Sprint5Page, PageConstants.Sprint5Url, PageConstants.Sprint5Title);	
		SetGenderType(Gender.Other);
		sprint5PageActions.FillOutPrimaryContactForm(TestUser);
		User TestEmergencyContactUser = new User(UserConstants.EmergencyContactFirstName, UserConstants.EmergencyContactLastName, Gender.Female);
        sprint5PageActions.FillOutEmergencyContactFormAndSubmit(TestEmergencyContactUser);
		ValidatePageTitle(sprint5PageActions.Sprint5Page, ErrorConstants.SampleApplicationPage2Error, PageConstants.FormPage2Title);		
		Sprint5Page2Actions sprint5Page2Actions = new Sprint5Page2Actions(Driver);
		sprint5Page2Actions.FillOutRadioButtonAndSubmit(Animal.Bunnies);
		ValidatePageTitle(sprint5PageActions.Sprint5Page, ErrorConstants.UltimateQaHomePageError, PageConstants.UltimateQaHomePageTitle);			
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