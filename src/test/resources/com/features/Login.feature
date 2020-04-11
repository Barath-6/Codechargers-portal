@SignInPage
Feature: Signin as member
	As a visitor of the engineers club website
	I want to see all information
	
	@SignIn
  Scenario: To signin  as member
    Given open application and clickon signin link
    When I enter valid details Login and password
    Then I click login button 
    And I navigate to homePage
    And I Logout
    
   
       
 