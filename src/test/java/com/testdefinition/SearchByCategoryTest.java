package com.testdefinition;

import com.pages.Base_Class;
import com.pages.SearchByCategoryPage;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SearchByCategoryTest extends Base_Class {

	SearchByCategoryPage search;

	@Given("^I am on the homepage$")
	public void i_am_on_the_homepage() throws Throwable {

		launchBrowser("http://examples.codecharge.com/portal/Default.php");
		Logger("Application opened");
		takeSnap();
		search=new SearchByCategoryPage(driver);
		test = report.startTest("search box Test");

	}

	@When("^I select category from searchbox$")
	public void i_select_category_from_searchbox() throws Throwable {

		search.selectcategory("Computers");
		search.clickonsearch();
		Logger("opened the required search results");
		test.log(LogStatus.PASS, "we got the requried category results");
		takeSnap();
	}

	@Then("^I get results about that category$")
	public void i_get_results_about_that_category() throws Throwable {

		search.clickonhomepage();
	    Logger("we are again back to homepage");
	    takeSnap();
	    Thread.sleep(3000);
		driver.quit();
		
		report.flush();
		report.endTest(test);
		report.flush();
	}


}
