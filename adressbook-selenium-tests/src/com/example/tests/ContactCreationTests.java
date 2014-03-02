package com.example.tests;

import static com.example.fw.ContactHelper.CREATION;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
    app.navigateTo().mainPage();
    
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    //actions
    app.getContactHelper()
      .initContactCreation()
      .fillContactForm(contact, CREATION)
      .submitContactCreation();
    app.navigateTo().returnToHomePage();
    
    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
 
}
