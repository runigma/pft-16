package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
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
 
}
