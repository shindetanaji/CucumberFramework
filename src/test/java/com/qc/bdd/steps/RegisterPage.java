package com.qc.bdd.steps;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterPage {

	WebDriver driver = LoginPage.getDriver();
	
	@Given("to click on register new membership link")
	public void to_click_on_register_new_membership_link() {
	    WebElement regLink = driver.findElement(By.partialLinkText("Register a new membership"));
	    regLink.click();
	}
	
	@Given("to enter the user name {string}")
	public void to_enter_the_user_name(String uName) {
	    WebElement name = driver.findElement(By.id("name"));
	    name.sendKeys(uName);
	}
	
	@Given("to enter the user mobile {string}")
	public void to_enter_the_user_mobile(String uMobile) {
	   WebElement mobile = driver.findElement(By.id("mobile"));
	   mobile.sendKeys(uMobile);
	}
	
	@Given("to enter the user email {string}")
	public void to_enter_the_user_email(String uEmail) {
	    WebElement email = driver.findElement(By.id("email"));
	    email.sendKeys(uEmail);
	}
	
	@Given("to enter the user password {string}")
	public void to_enter_the_user_password(String uPass) {
	   WebElement pass = driver.findElement(By.id("password"));
	   pass.sendKeys(uPass);
	}
	
	@When("to click on submit button")
	public void to_click_on_submit_button() {
	    WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
	    submit.click();
	}
	
	@Then("to validate success message {string}")
	public void to_validate_success_message(String expResult) {
	    Alert alt = driver.switchTo().alert();
	    String actResult = alt.getText();
	    Assert.assertEquals(actResult, expResult);
	    alt.accept();
	}

	@Then("to validate register page title {string}")
	public void to_validate_register_page_title(String expResult) {
		String actResult = driver.getTitle();
		Assert.assertEquals(actResult, expResult);
	}




}
