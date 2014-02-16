package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;
import com.example.tests.TestBase;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreation() {
		driver.findElement(By.linkText("add new")).click();
	}

	public void fillContactForm(ApplicationManager applicationManager, TestBase testBase, ContactData contact) {
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

	public void submitContactCreation() {
		driver.findElement(By.name("submit")).click();
	}

}
