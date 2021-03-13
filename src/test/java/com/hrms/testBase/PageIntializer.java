package com.hrms.testBase;

import com.hrms.pages.LoginPageElements;

public class PageIntializer {
	protected static LoginPageElements login;
	public static void initializeAll() {
		login = new LoginPageElements();
}
}
