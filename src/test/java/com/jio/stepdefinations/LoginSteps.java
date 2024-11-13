package com.jio.stepdefinations;

import static org.testng.Assert.assertTrue;

import com.jio.base.BaseTest;
import com.jio.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseTest{
	private LoginPage loginPage;

   
	/*
	 * @Override public void setUp() {
	 * 
	 * super.setUp(); loginPage = new LoginPage(driver);
	 * 
	 * }
	 */

    @Given("the user is on the login page")
    public void user_on_login_page() {
    	setUp();
    	loginPage = new LoginPage(driver); 
       // driver.get("https://www.facebook.com/");
    }

	    @When("the user enters {string} and {string}")
	    public void user_enters_credentials(String username, String password) {
	        loginPage.enterUsername(username);
	        loginPage.enterPassword(password);
	        loginPage.clickLogin();
	    }

	    @Then("the user should be logged in successfully")
	    public void verify_login() {
	        // Add your verification logic here (e.g., checking for a successful login)
	        assertTrue(driver.getTitle().contains("Dashboard"));
	    }

	    // This method will run after each scenario, inherited from BaseTest
	    @Override
	    public void tearDown() {
	        super.tearDown();
	    }
}
