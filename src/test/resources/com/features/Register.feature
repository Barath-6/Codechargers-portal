
@Registration
Feature: Membership for engineers club application

@RegisterNewUser
Scenario: Registering as new user
Given Open application and click on Registeration link
When the user enters the details and click add
Then the system stores the details and automatically create a membership
And check if the user is added as a member or not by clicking maembers link
