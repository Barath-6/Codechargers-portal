package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	public void ClickOnSignInLink() {
		
		driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td/table/tbody/tr/td[8]/a")).click();
	}
	
	public void enter_Login(String name) {
		
		driver.findElement(By.name("login")).sendKeys(name);
		
	}
	public void enter_password(String pwd) {
		
		driver.findElement(By.name("password")).sendKeys(pwd);
		
	}

	public void clickon_Login() {
		
		driver.findElement(By.name("Button_DoLogin")).click();
	}
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
}
