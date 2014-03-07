package com.example.fw;

import java.util.Properties;


public class ApplicationManager {
	
	private static ApplicationManager singleton;
	
	private Properties props;

	private FolderHelper folderHelper;
	
	private static ApplicationManager getInstance() {
		if (singleton == null) {
			singleton = new ApplicationManager(); 
		}
		return singleton;
	}

	
	public void stop() {
	}
	
	public void setProperties(Properties props) {
		this.props = props;		
	}
	
	public String getProperty(String key) {
		return props.getProperty(key);		
	}
	
	public String getProperty(String key, String defaultValue) {
		return props.getProperty(key, defaultValue);		
	}


	public FolderHelper getFolderHelper() {
		if (folderHelper == null) {
			folderHelper = new FolderHelper();
		}
		return folderHelper;
	}

}
