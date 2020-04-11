@AdministrationPage

Feature: AdminstrationPage 

@AdminSignIn
Scenario: sign as admin
Given I am on homepage and click on admin link
When the I enters the details and click on login
Then I get administration menu

@AddEvents
Scenario: Add Events
Given I am on adminpage and click on events link
And click on add new
When i enters the details and click on add
Then that event is displayed on events table 

