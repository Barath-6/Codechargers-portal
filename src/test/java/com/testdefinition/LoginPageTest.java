package com.testdefinition;

import org.openqa.selenium.By;

import com.pages.Base_Class;
import com.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageTest extends Base_Class{
	
	
	LoginPage login;
	
	@Given("^open application and clickon signin link$")
	public void open_application_and_clickon_signin_link() throws Throwable {
	   
		launchBrowser("http://examples.codecharge.com/portal/Default.php");
		Base_Class.Logger("Application opened");
		takeSnap();
		login=new LoginPage(driver);
		
		test=report.startTest("LogInPageTest");
		
		login.ClickOnSignInLink();
		
		if (driver.getTitle().equals("Login")) {
			
			Logger("SignIn Page Opened");
			
		} else {

			Logger("SignIn Page Not Opened");
		}		
		takeSnap();
	}

	@When("^I enter valid details Login and password$")
	public void i_enter_valid_details_Login_and_password() throws Throwable {
	   
		login.enter_Login("bharath");
		login.enter_password("kbk");
	}

	@Then("^I click login button$")
	public void i_click_login_button() throws Throwable {
	   
		login.clickon_Login();
		
	}

	@Then("^I navigate to homePage$")
	public void i_navigate_to_homePage() throws Throwable {
	    
		if (driver.getTitle().equals("Silicon Valley Engineers Club")) {
			
			Logger("HomePage Opened");
			
		} else {
			
			Logger("HomePage Not Opened");
		}
		takeSnap();
		
		test.log(LogStatus.PASS, "SignIn Successfull");
		
	}

	@Then("^I Logout$")
	public void i_Logout() throws Throwable {
	   
		driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td/table/tbody/tr/td[8]/a")).click();
		driver.findElement(By.partialLinkText("Logout")).click();
		
		
		takeSnap();
		
		report.flush();
		report.endTest(test);
		
		
		Thread.sleep(3000);
		driver.quit();
	}
	

}
