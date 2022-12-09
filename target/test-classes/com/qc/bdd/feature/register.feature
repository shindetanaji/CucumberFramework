@register @queuecodes
Feature: To validate all register user test cases

Background:
	Given launch login page on browser
	And to click on register new membership link

@validRegister	
Scenario: To validate success message once user will register with valid data
		Given to enter the user name "Queue Codes"
		And to enter the user mobile "9145425494"
		And to enter the user email "queuecodes@gmail.com"
		And to enter the user password "123123"
		When to click on submit button
		Then to validate success message "User registered successfully."
		And to close the browser

@invalidRegister
Scenario Outline: To validate register page title once user will enter invalid data
		Given to enter the user name "<userName>"
		And to enter the user mobile "<userMobile>"
		And to enter the user email "<userEmail>"
		And to enter the user password "<userPassword>"
		When to click on submit button
		Then to validate register page title "Queue Codes | Registration Page"
		And to close the browser
		Examples:
			|				testName			|	userName	|userMobile|		userEmail				|userPassword|
			|All are empty				|						|					 |										|						 |
			|userName is empty		|						|9145425494|queuecodes@gmail.com|   123123	 |
			|userMobile is empty	|Queue Codes|					 |queuecodes@gmail.com|   123123   |
			|userEmail is empty		|Queue Codes|9145425494|										|   123123   |
			|userPassword is empty|Queue Codes|9145425494|queuecodes@gmail.com|            |
