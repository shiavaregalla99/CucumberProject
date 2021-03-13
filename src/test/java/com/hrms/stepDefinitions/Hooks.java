package com.hrms.stepDefinitions;

import com.hrms.testBase.BaseClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void beforeScenario() {
		BaseClass.setUp();
	}
	
	@After
	public void afterScenario() {
		BaseClass.tearDown();
	}
}
