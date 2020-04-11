package com.tests;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\com\\features",
tags= {"@SignIn"},
glue= {"com.testdefinition"})
public class LoginPageTestRunner {

private TestNGCucumberRunner testRunner;
	
	@BeforeClass
	public void setUP()
	{
		testRunner = new TestNGCucumberRunner(LoginPageTestRunner.class);			
	}
	
	@Test(description="login",dataProvider="features")
	public void login(CucumberFeatureWrapper cFeature)
	{
		testRunner.runCucumber(cFeature.getCucumberFeature());
	}
	
	@DataProvider(name="features")
	public Object[][] getFeatures()
	{
		return testRunner.provideFeatures();
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{		
		testRunner.finish();
		
	}
	
	

	
}
