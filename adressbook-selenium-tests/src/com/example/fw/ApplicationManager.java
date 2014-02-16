package com.example.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class ApplicationManager {
	
	// Methods for group creation	

	public void returnToGroupsPage() {
		TestBase.driver.findElement(By.linkText("group page")).click();
	}

	public void submitGroupCreation() {
		TestBase.driver.findElement(By.name("submit")).click();
	}

	public void fillGroupForm(TestBase testBase, GroupData group) {
		TestBase.driver.findElement(By.name("group_name")).clear();
	    TestBase.driver.findElement(By.name("group_name")).sendKeys(group.name);
	    TestBase.driver.findElement(By.name("group_header")).clear();
	    TestBase.driver.findElement(By.name("group_header")).sendKeys(group.header);
	    TestBase.driver.findElement(By.name("group_footer")).clear();
	    TestBase.driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	public void initGroupCreation() {
		TestBase.driver.findElement(By.name("new")).click();
	}

	public void gotoGroupsPage() {
		TestBase.driver.findElement(By.linkText("groups")).click();
	}

	public void openMainPage() {
		TestBase.driver.get(TestBase.baseUrl + "/addressbookv4.1.4/");
	}

	public void returnToHomePage() {
		TestBase.driver.findElement(By.linkText("home page")).click();
	}

	// Methods for contact creation	
	
	public void submitContactCreation() {
		TestBase.driver.findElement(By.name("submit")).click();
	}

	public void fillContactForm(TestBase testBase, ContactData contact) {
		TestBase.driver.findElement(By.name("firstname")).clear();
	    TestBase.driver.findElement(By.name("firstname")).sendKeys(contact.firstname);
	    TestBase.driver.findElement(By.name("lastname")).clear();
	    TestBase.driver.findElement(By.name("lastname")).sendKeys(contact.lastname);
	    TestBase.driver.findElement(By.name("address")).clear();
	    TestBase.driver.findElement(By.name("address")).sendKeys(contact.address);
	    TestBase.driver.findElement(By.name("home")).clear();
	    TestBase.driver.findElement(By.name("home")).sendKeys(contact.homephone);
	    TestBase.driver.findElement(By.name("mobile")).clear();
	    TestBase.driver.findElement(By.name("mobile")).sendKeys(contact.mobilephone);
	    TestBase.driver.findElement(By.name("work")).clear();
	    TestBase.driver.findElement(By.name("work")).sendKeys(contact.workphone);
	    TestBase.driver.findElement(By.name("email")).clear();
	    TestBase.driver.findElement(By.name("email")).sendKeys(contact.firstemail);
	    TestBase.driver.findElement(By.name("email2")).clear();
	    TestBase.driver.findElement(By.name("email2")).sendKeys(contact.secondemail);
	    new Select(TestBase.driver.findElement(By.name("bday"))).selectByVisibleText(contact.day);
	    new Select(TestBase.driver.findElement(By.name("bmonth"))).selectByVisibleText(contact.month);
	    TestBase.driver.findElement(By.name("byear")).clear();
	    TestBase.driver.findElement(By.name("byear")).sendKeys(contact.year);
	    new Select(TestBase.driver.findElement(By.name("new_group"))).selectByVisibleText(contact.groupname);
	    TestBase.driver.findElement(By.name("address2")).clear();
	    TestBase.driver.findElement(By.name("address2")).sendKeys(contact.secondaddress);
	    TestBase.driver.findElement(By.name("phone2")).clear();
	    TestBase.driver.findElement(By.name("phone2")).sendKeys(contact.secondphone);
	}

	public void initContactCreation() {
		TestBase.driver.findElement(By.linkText("add new")).click();
	}

	// some additional methods for elements location and alert handling	
	
	public boolean isElementPresent(By by) {
	    try {
	      TestBase.driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	public boolean isAlertPresent() {
	    try {
	      TestBase.driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	public String closeAlertAndGetItsText() {
	    try {
	      Alert alert = TestBase.driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (TestBase.acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      TestBase.acceptNextAlert = true;
	    }
	  }

}
