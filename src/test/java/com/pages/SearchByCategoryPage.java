package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchByCategoryPage {
	
WebDriver driver;
	
	public SearchByCategoryPage(WebDriver driver) {
		this.driver=driver;
	}

	public void selectcategory(String s) {
		Select cat=new Select(driver.findElement(By.name("category_id")));
		cat.selectByVisibleText(s);
	}
	public void clickonsearch() {
		driver.findElement(By.name("DoSearch")).click();
	}
	public void clickonhomepage() {
		driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td/table/tbody/tr/td[1]/a/img")).click();
	}


}
