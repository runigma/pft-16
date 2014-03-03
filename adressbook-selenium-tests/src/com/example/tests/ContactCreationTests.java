package com.example.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase {

  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
    //save old state
	SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
    
    //actions
    app.getContactHelper().createContact(contact);     
    
    //save new state
    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states
    oldList.add(contact);
    assertEquals(newList, oldList);
  }
 
}
