package com.qc.bdd.steps;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qc.bdd.utils.TestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage {

	static WebDriver driver;
	WebElement email, pass, signIn, logout;
	TestUtils test = new TestUtils();
	Properties prop;

	@Given("^launch login page on browser$")
	public void launch_login_page_on_browser() throws IOException {
		prop = test.readProp();
		if (prop.getProperty("browser").equals("chrome")) {
			System.setProperty(prop.getProperty("chromeKey"), prop.getProperty("chromeVal"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		driver.get(prop.getProperty("siteUrl"));
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	@Given("^enter the email id \"([^\"]*)\"$")
	public void enter_the_email_id(String uName) {
		email = driver.findElement(By.id("email"));
		email.sendKeys(uName);
	}

	@Given("^enter the password \"([^\"]*)\"$")
	public void enter_the_password(String uPass) {
		pass = driver.findElement(By.id("password"));
		pass.sendKeys(uPass);
	}

	@When("^to click on login button$")
	public void to_click_on_login_button() {
		signIn = driver.findElement(By.id("submit"));
		signIn.click();
	}

	@Then("^to validate dashobard page title \"([^\"]*)\"$")
	public void to_validate_dashobard_page_title(String expResult) {
		String actResult = driver.getTitle();
		Assert.assertEquals(actResult, expResult);
	}
	
	@Then("to click on logout button")
	public void to_click_on_logout_button() {
	   logout = driver.findElement(By.id("hlogout"));
	   logout.click();
	}
	
	@Then("to close the browser")
	public void to_close_the_browser() {
	    driver.close();
	}



}
