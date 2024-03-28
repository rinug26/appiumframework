#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Addition feature

  @login
  Scenario Outline: Adding two values
    Given I launch the application
    When I enter username "<value1>"
    And I enter password "<value2>"
    And I click on login button
    Then I navigate to homescreen
    Examples:
    |value1|value2|
    |addYourUsernameHere|AddYourPasswordHere|
    
    
    
    
    
    
    
    
    
    