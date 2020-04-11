package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {
	
	WebDriver driver;

	public AdminPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void Click_On_Admin_Link() {
		
		driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td/table/tbody/tr/td[9]/a")).click();
		
	}
	
	public void enter_Login(String name) {
		
		driver.findElement(By.name("login")).sendKeys(name);
		
	}
	public void Enter_Password(String pwd) {
		
		driver.findElement(By.name("password")).sendKeys(pwd);
		
	}
	
	public void Click_On_Login() {
		
		driver.findElement(By.name("Button_DoLogin")).click();
		
	}

}
