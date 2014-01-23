package com.example.tests;

import org.testng.annotations.Test;

public class AlsoOfGroupCreationTests extends TestBase {  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    fillGroupForm(new GroupData("", "", ""));
    submitGroupCreation();
    returnToGroupsPage();
  }
}
