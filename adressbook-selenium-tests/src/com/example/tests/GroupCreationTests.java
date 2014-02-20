package com.example.tests;

import java.util.List;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getGroupHelper().gotoGroupsPage();
    
    //save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    //actions
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
	group.name = "group name 1";
	group.header = "header 1";
	group.footer = "footer 1";	
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    //compare states
    assertEquals(newList.size(),oldList.size()+1);
  }
}
