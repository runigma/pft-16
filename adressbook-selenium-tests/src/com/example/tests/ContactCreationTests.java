package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactCreationTests extends TestBase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled() throws Exception {
    openMainPage();	  
    initContactCreation();
    ContactData contact = new ContactData();
	contact.firstname = "first name 1";
	contact.lastname = "last name 1";
	contact.address = "address 1";
	contact.homephone = "123";
	contact.mobilephone = "456";
	contact.workphone = "789";
	contact.firstemail = "test1@test.test";
	contact.secondemail = "test2@test.test";
	contact.day = "1";
	contact.month = "January";
	contact.year = "2000";
	contact.groupname = "group name 1";
	contact.secondaddress = "address 2";
	contact.secondphone = "home 1";	
    fillContactForm(contact);
    submitContactCreation();
    returnToHomePage();
  }

private void returnToHomePage() {
	driver.findElement(By.linkText("home page")).click();
}

private void submitContactCreation() {
	driver.findElement(By.name("submit")).click();
}

private void fillContactForm(ContactData contact) {
	driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys(contact.firstname);
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys(contact.lastname);
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys(contact.address);
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys(contact.homephone);
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys(contact.mobilephone);
    driver.findElement(By.name("work")).clear();
    driver.findElement(By.name("work")).sendKeys(contact.workphone);
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys(contact.firstemail);
    driver.findElement(By.name("email2")).clear();
    driver.findElement(By.name("email2")).sendKeys(contact.secondemail);
    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contact.day);
    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contact.month);
    driver.findElement(By.name("byear")).clear();
    driver.findElement(By.name("byear")).sendKeys(contact.year);
    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contact.groupname);
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys(contact.secondaddress);
    driver.findElement(By.name("phone2")).clear();
    driver.findElement(By.name("phone2")).sendKeys(contact.secondphone);
}

private void initContactCreation() {
	driver.findElement(By.linkText("add new")).click();
}

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
