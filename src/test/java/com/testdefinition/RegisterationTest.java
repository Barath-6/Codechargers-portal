package com.testdefinition;

import java.io.FileInputStream;

import org.openqa.selenium.By;

import com.pages.Base_Class;
import com.pages.RegisterationPage;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jxl.Sheet;
import jxl.Workbook;

public class RegisterationTest extends Base_Class {

	RegisterationPage register;

	@Given("^Open application and click on Registeration link$")
	public void open_application_and_click_on_Registeration_link() throws Throwable {
		launchBrowser("http://examples.codecharge.com/portal/Default.php");
		Base_Class.Logger("application opened");
		takeSnap();
		register=new RegisterationPage(driver);

		test=report.startTest("RegistrationTest");

		register.clickregistration();


		if (driver.getTitle().equals("Registration")) {

			Base_Class.Logger("Registration Page opened");

			test.log(LogStatus.PASS, "Registeration Page Opened");

		} else {

			Base_Class.Logger("Registration Page Not Opened");
			test.log(LogStatus.FAIL, "Registeration Page not Opened");
		}
		takeSnap();

	}

	@When("^the user enters the details and click add$")
	public void the_user_enters_the_details_and_click_add() throws Throwable {

		String FilePath="src\\test\\resources\\com\\TestData\\DataDriven.xls";
		FileInputStream fs=new FileInputStream(FilePath);

		Workbook wb=Workbook.getWorkbook(fs);

		Sheet sh=wb.getSheet("Sheet1");



		for (int row = 1; row < 4; row++) {

			register.clickregistration();

			for (int col = 0; col < 5; col++) {

				String value1=sh.getCell(col, row).getContents();
				if (col==0) {

					register.enterlogin(value1);
				}
				if (col==1) {

					register.enterPassword(value1);
				}
				if (col==2) {
					register.enterFirstname(value1);
				}
				if (col==3) {
					register.enterLastname(value1);
				}
				if (col==4) {
					register.enterEmail(value1);
				}


			}
			driver.findElement(By.name("Insert")).click();
		}

	}

	@Then("^the system stores the details and automatically create a membership$")
	public void the_system_stores_the_details_and_automatically_create_a_membership() throws Throwable {

		if (driver.getTitle().equals("Silicon Valley Engineers Club")) {

			Base_Class.Logger("HomePage Opened");
			test.log(LogStatus.PASS, "New User details are stored successfully");

		} else {
			Base_Class.Logger("HomePage not Opened");

			test.log(LogStatus.FAIL, "New User details are not stored successfully");

		}



	}

	@Then("^check if the user is added as a member or not by clicking maembers link$")
	public void check_if_the_user_is_added_as_a_member_or_not_by_clicking_maembers_link() throws Throwable {

		register.clickmembers();

		takeSnap();

		Thread.sleep(3000);
		driver.quit();

		report.flush();
		report.endTest(test);



	}


}
