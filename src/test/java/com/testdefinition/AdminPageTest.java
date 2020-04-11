package com.testdefinition;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.pages.AdminPage;
import com.pages.Base_Class;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jxl.Sheet;
import jxl.Workbook;

public class AdminPageTest extends Base_Class {

	AdminPage page;
	WebElement table;
	



	@Given("^I am on homepage and click on admin link$")
	public void i_am_on_homepage_and_click_on_admin_link() throws Throwable {

		launchBrowser("http://examples.codecharge.com/portal/Default.php");

		page=new AdminPage(driver);

		test=report.startTest("AdminPageTest");

		page.Click_On_Admin_Link();

		if (driver.getTitle().equals("Login")) {

			Logger("I am in admin login page");
			takeSnap();

		} else {

			Logger("I amnot in login page");

		}




	}

	@When("^the I enters the details and click on login$")
	public void the_I_enters_the_details_and_click_on_login() throws Throwable {

		page.enter_Login("admin");
		page.Enter_Password("admin");
		page.Click_On_Login();

	}

	@Then("^I get administration menu$")
	public void i_get_administration_menu() throws Throwable {

		if (driver.getTitle().equals("Administration")) {

			Logger("I am On AdministrationPage");

		} else {

			Logger("I am not in administration page");

		}


	}

	@Given("^I am on adminpage and click on events link$")
	public void i_am_on_adminpage_and_click_on_events_link() throws Throwable {


		WebElement table=driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/center/table/tbody/tr/td/table[2]/tbody"));
		table.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/center/table/tbody/tr/td/table[2]/tbody/tr[2]/td/a[2]")).click();



	}

	@Given("^click on add new$")
	public void click_on_add_new() throws Throwable {

		WebElement table=driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/center/table/tbody/tr/td/table[2]/tbody"));
		table.findElement(By.partialLinkText("Add New")).click();


	}

	@When("^i enters the details and click on add$")
	public void i_enters_the_details_and_click_on_add() throws Throwable {

		String FilePath="src\\test\\resources\\com\\TestData\\EventDetails.xls";
		FileInputStream fs=new FileInputStream(FilePath);

		Workbook wb=Workbook.getWorkbook(fs);

		Sheet sh=wb.getSheet("Sheet1");

		int tablerows=sh.getRows();
		int tablecols=sh.getColumns();
		table=driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/center/form/table/tbody/tr/td/table[2]/tbody"));

		for (int row = 0; row < tablerows; row++) {

			

			for (int col = 0; col < tablecols; col++) {

				String value1=sh.getCell(col, row).getContents();
				if (col==0) {

					table.findElement(By.name("date_start")).sendKeys(value1);

				}
				if (col==1) {

					table.findElement(By.name("event_name")).sendKeys(value1);

				}
				if (col==2) {

					table.findElement(By.name("event_desc")).sendKeys(value1);

				}
				if (col==3) {

					table.findElement(By.name("location")).sendKeys(value1);

				}
				if (col==4) {

					table.findElement(By.name("presenter")).sendKeys(value1);

				}

			}

			
		}


		table.findElement(By.name("Insert")).click();


		takeSnap();

		test.log(LogStatus.PASS, "Event Successfully Added");



	}

	@Then("^that event is displayed on events table$")
	public void that_event_is_displayed_on_events_table() throws Throwable {
		
		report.flush();
		report.endTest(test);
		Thread.sleep(3000);
		driver.quit();		

	}

}
