package com.example.tests;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.fw.Folders;

public class TestFolderRemoval extends TestBase {
	
	@Test
	public void testFolderRemoval() {
		Folders oldFolders = app.getFolderHelper().getFolders();
		Random rnd = new Random();
	    int index = rnd.nextInt(oldFolders.size());
	    app.getFolderHelper().deleteFolder(index);
	    Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.without(index)));		
	}
	

}
