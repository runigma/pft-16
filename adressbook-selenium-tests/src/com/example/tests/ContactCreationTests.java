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
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys("first name 1");
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("last name 1");
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys("address 1");
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys("123");
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys("456");
    driver.findElement(By.name("work")).clear();
    driver.findElement(By.name("work")).sendKeys("789");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("test1@test.test");
    driver.findElement(By.name("email2")).clear();
    driver.findElement(By.name("email2")).sendKeys("test2@test.test");
    new Select(driver.findElement(By.name("bday"))).selectByVisibleText("1");
    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("January");
    driver.findElement(By.name("byear")).clear();
    driver.findElement(By.name("byear")).sendKeys("2000");
    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText("group name 1");
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys("address 2");
    driver.findElement(By.name("phone2")).clear();
    driver.findElement(By.name("phone2")).sendKeys("home 1");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("home page")).click();
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
