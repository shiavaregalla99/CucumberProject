package com.hrms.stepDefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.hrms.testBase.BaseClass;
import com.hrms.testBase.PageIntializer;
import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;


public class Steps extends PageIntializer {
	
	
	
	@When("User Enters credentials {string} and {string}")
	public void user_Enters_credentials_and(String username, String password) {
		CommonMethods.sendText(login.username, username);
		CommonMethods.sendText(login.password, password);
	}

//	@When("User Enters valid username and valid password")
//	public void user_Enters_valid_username_and_valid_password() {
//		CommonMethods.sendText(login.username, "admin");
//		CommonMethods.sendText(login.password, "admin123");
//	}

	@When("User Clicks on the login button")
	public void user_Clicks_on_the_login_button() {
		CommonMethods.click(login.loginBtn);
	}

	@Then("User Successfully login into the application")
	public void user_Successfully_login_into_the_application() {
	String actualTitle=	BaseClass.driver.getTitle();
	System.out.println("actualTitle "+actualTitle);
	String expectedTitle="OrangeHRM";
	Assert.assertEquals(actualTitle, expectedTitle,"values are not equal");
	
	}

	@Then("User should be able to see error message as {string}")
	public void user_should_be_able_to_see_error_message_as(String ExpectederrorMessage) {
	  String actualErrorMessage=    login.errorMsg.getText();
	  Assert.assertEquals(actualErrorMessage, ExpectederrorMessage,"error message is not displayed");
	
	}
	@When("User enters invalid username and password and see error message")
	public void user_enters_invalid_username_and_password_and_see_error_message(DataTable invalidData) {
	   List<Map<String,String>>    list=      invalidData.asMaps();
	   
	   for(Map<String,String> map:list) {
		   CommonMethods.sendText(login.username, map.get("username"));
		   CommonMethods.sendText(login.password, map.get("password"));
		   CommonMethods.click(login.loginBtn);
		   Assert.assertEquals(map.get("errorMessage"), login.errorMsg.getText(),
				   "error message is not displayed");
	   }
		
		
	}



}
