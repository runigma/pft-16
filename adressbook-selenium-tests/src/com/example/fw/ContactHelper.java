package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact) {
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
	    selectByText(By.name("new_group"), contact.getGroupname());
	    type(By.name("address2"), contact.getSecondaddress());
	    type(By.name("phone2"), contact.getSecondphone());
	    return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		return this;
	}

	public ContactHelper deleteContact(int index) {
		clickContactForEditionByIndex(index);
		click(By.xpath("//input[@value='Delete']"));
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
		return this;
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> rows = driver.findElements(By.xpath("//tr[@name='entry']"));
		for (WebElement row : rows) {
			ContactData contact = new ContactData()
			 .withFirstname(row.findElement(By.xpath("./td[3]")).getText())
			 .withLastname(row.findElement(By.xpath("./td[2]")).getText());
			contacts.add(contact);
		}
		return contacts;
	}	
	
	
}
