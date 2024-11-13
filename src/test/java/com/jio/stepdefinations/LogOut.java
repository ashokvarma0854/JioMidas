package com.jio.stepdefinations;

import com.jio.base.BaseTest;
import com.jio.pages.LoginPage;

import io.cucumber.java.en.Given;

public class LogOut extends BaseTest {
	public LoginPage loginPage;
	@Given("the user is on the login page and then logout")
	public void the_user_is_on_the_login_page_and_then_logout() {
		setUp();
    	loginPage = new LoginPage(driver); 
	}
}
