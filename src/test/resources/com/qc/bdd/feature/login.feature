@login
Feature: To validate all queue codes login conditions with different data

Background:
	Given launch login page on browser

  @validLogin
  Scenario: To validate dashobard page title once user will enter valid data
    Given enter the email id "queuecodes@gmail.com"
    And enter the password "123456"
    When to click on login button
    Then to validate dashobard page title "Queue Codes | Dashboard"
    And to click on logout button
    And to close the browser
   
  @invalidLogin  
  Scenario Outline: To validate login page title once user will enter invalid login data
  	Given enter the email id "<userName>"
    And enter the password "<userPassword>"
    When to click on login button
    Then to validate dashobard page title "Queue Codes | Log in"
    And to close the browser
	 	Examples:
			|		 testName			|			userName			 |userPassword|
			|Both are empty		|										 |						|
			|Email is empty		|										 |	 123456		|
			|Pass is empty		|queuecodes@gmail.com|						|
			|Both are invalid	|queuecodes@gmail.   |	 123123		|
			|Email is invalid	|queuecodes@gmail.	 |	 123456		|
			|Pass is invalid	|queuecodes@gmail.com|	 123123		|
 