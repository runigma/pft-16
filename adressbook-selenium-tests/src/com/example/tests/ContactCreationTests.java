package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    //actions
    app.getContactHelper().initContactCreation();
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
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();
    
    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states
    contact.firstname = contact.firstname + " " + contact.lastname;
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
 
}
