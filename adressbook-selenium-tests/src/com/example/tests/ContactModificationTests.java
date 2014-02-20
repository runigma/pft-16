package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact(){
		app.getNavigationHelper().openMainPage();
		
		//save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    //actions
		app.getContactHelper().initContactModification(0);
		ContactData contact = new ContactData();
		contact.firstname = "NEW FIRST NAME 1";
		contact.lastname = "NEW LAST NAME 1";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getNavigationHelper().returnToHomePage();
		
		//save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    contact.firstname = contact.firstname + " " + contact.lastname;
	    oldList.remove(0);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}

}
