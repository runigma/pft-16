package com.example.tests;

import org.testng.annotations.Test;

public class AlsoOfGroupCreationTests extends TestBase {  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    app.navigationHelper.openMainPage();
    app.groupHelper.gotoGroupsPage();
    app.groupHelper.initGroupCreation();
    app.groupHelper.fillGroupForm(new GroupData("", "", ""));
    app.groupHelper.submitGroupCreation();
    app.groupHelper.returnToGroupsPage();
  }
}
