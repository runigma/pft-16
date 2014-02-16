package com.example.tests;

import org.testng.annotations.Test;

public class AlsoOfGroupCreationTests extends TestBase {  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    app.openMainPage();
    app.gotoGroupsPage();
    app.initGroupCreation();
    app.fillGroupForm(this, new GroupData("", "", ""));
    app.submitGroupCreation();
    app.returnToGroupsPage();
  }
}
