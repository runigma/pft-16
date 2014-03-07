package com.example.tests;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matcher.*;

import org.testng.annotations.Test;

public class TestFolderCreation extends TestBase {
	
	@Test	
	public void testFolderCreation() {
		String folder = "newfolder";
		Folders oldFolders = app.getFolderHelper().getFolders();
		app.getFolderHelper().CreateFolder(folder);
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.withAdded(folder)));
	}

}
