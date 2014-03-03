package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATIOIN = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private List<ContactData> cachedContacts;
	
	public List<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildContactsCache();
		}
		return cachedContacts;				
	}

	private void rebuildContactsCache() {
List<ContactData> cachedContacts = new ArrayList<ContactData>();
		
		manager.navigateTo().mainPage();
		List<WebElement> rows = driver.findElements(By.xpath("//tr[@name='entry']"));
		for (WebElement row : rows) {
			ContactData contact = new ContactData()
			 .withFirstname(row.findElement(By.xpath("./td[3]")).getText())
			 .withLastname(row.findElement(By.xpath("./td[2]")).getText());
			cachedContacts.add(contact);
		}		
	}
	
	public ContactHelper createContact(ContactData contact) {
		initContactCreation();
	    fillContactForm(contact, CREATION);
	    submitContactCreation();
	    returnToHomePage();	
	    rebuildContactsCache();
	    return this;
	}
	
	public ContactHelper modifyContact(int index, ContactData contact) {
		initContactModification(index);
		fillContactForm(contact, MODIFICATIOIN);
		submitContactModification();
		returnToHomePage();
		rebuildContactsCache();
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		clickContactForEditionByIndex(index);
		submitContactDeletion();
		returnToHomePage();
		rebuildContactsCache();
		return this;
	}
	
//-----------------------------------------------------------------------	
	
	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getHomephone());
		type(By.name("mobile"), contact.getMobilephone());
		type(By.name("work"), contact.getWorkphone());
		type(By.name("email"), contact.getFirstemail());
		type(By.name("email2"), contact.getSecondemail());
	    selectByText(By.name("bday"), contact.getDay());
	    selectByText(By.name("bmonth"), contact.getMonth());	    	    	    
	    type(By.name("byear"), contact.getYear());
	    if (formType == CREATION){
	    	//selectByText(By.name("new_group"), "group 1");
	    } else {
	    	if (driver.findElements(By.name("new_group")).size() != 0) {
	    		throw new Error("Group selector exists in contact modification form");
	    	}
	    }	    
	    type(By.name("address2"), contact.getSecondaddress());
	    type(By.name("phone2"), contact.getSecondphone());
	    return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	private ContactHelper clickContactForEditionByIndex(int index) {
		//click(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[" + (index + 1) + "]/td[7]/a/img"));
		click(By.xpath("(//img[@alt='Edit'])[" + (index + 1) + "]"));
		return this;
	}

	public ContactHelper initContactModification(int index) {
		clickContactForEditionByIndex(index);
		return this;
	}

	public ContactHelper submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
		cachedContacts = null;
		return this;
	}
	
	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}
	
	public ContactHelper submitContactDeletion() {
		click(By.xpath("//input[@value='Delete']"));
		cachedContacts = null;
		return this;
	}
	
}
