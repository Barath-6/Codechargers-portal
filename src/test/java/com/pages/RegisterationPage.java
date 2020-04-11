package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterationPage {
	
	WebDriver driver;
	WebElement register,login,password,firstname,lastname,email,add,member;
	public void clickregistration() {
		register=driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td/table/tbody/tr/td[2]/a"));
		register.click();
	}

	public void enterlogin(String s) {
		login=driver.findElement(By.name("member_login"));
		login.sendKeys(s);
	}

	public void enterPassword(String s) {
		password=driver.findElement(By.name("member_password"));
		password.sendKeys(s);
	}
	public RegisterationPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void enterFirstname(String s)
	{
		firstname = driver.findElement(By.name("first_name"));
		firstname.sendKeys(s);
	}
	public void enterLastname(String s) {
		lastname=driver.findElement(By.name("last_name"));
		lastname.sendKeys(s);
	}
	public void enterEmail(String s) {
		email=driver.findElement(By.name("email"));
		email.sendKeys(s);
		}
	public void clickAdd() {
		register=driver.findElement(By.name("Insert"));
		register.click();
	}	
	public void clickmembers() {
		member=driver.findElement(By.linkText("Members"));
		member.click();
	}

	 
	}



