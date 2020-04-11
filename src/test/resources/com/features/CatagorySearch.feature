@SearchByCategory
Feature: Search by category

@search
Scenario: Search category from searchbox
Given I am on the homepage
When I select category from searchbox
Then I get results about that category