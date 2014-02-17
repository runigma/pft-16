package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
		type(By.name("lastname"), contact.lastname);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.homephone);
		type(By.name("mobile"), contact.mobilephone);
		type(By.name("work"), contact.workphone);
		type(By.name("email"), contact.firstemail);
		type(By.name("email2"), contact.secondemail);
	    selectByText(By.name("bday"), contact.day);
	    selectByText(By.name("bmonth"), contact.month);	    	    	    
	    type(By.name("byear"), contact.year);
	    selectByText(By.name("new_group"), contact.groupname);
	    type(By.name("address2"), contact.secondaddress);
	    type(By.name("phone2"), contact.secondphone);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void deleteContact(int index) {
		clickContactForEditionByIndex(index);
		click(By.xpath("//input[@value='Delete']"));		
	}

	private void clickContactForEditionByIndex(int index) {
		//click(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[" + (index + 1) + "]/td[7]/a/img"));
		click(By.xpath("(//img[@alt='Edit'])[" + (index + 1) + "]"));
	}

	public void initContactModification(int index) {
		clickContactForEditionByIndex(index);
		
	}

	public void submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
		
	}	
	
	
}
