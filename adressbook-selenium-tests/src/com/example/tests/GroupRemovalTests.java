package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeGroup(){
		app.getNavigationHelper().openMainPage();
	    app.getGroupHelper().gotoGroupsPage();
		app.getGroupHelper().deleteGroup(1);
		app.getGroupHelper().returnToGroupsPage();
	}

}
