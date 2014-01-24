package com.example.tests;

public class ContactData {
	public String firstname;
	public String lastname;
	public String address;
	public String homephone;
	public String mobilephone;
	public String workphone;
	public String firstemail;
	public String secondemail;
	public String day;
	public String month;
	public String year;
	public String groupname;
	public String secondaddress;
	public String secondphone;

	public ContactData() {
		
	}
	
	public ContactData(String firstname, String lastname, String address,
			String homephone, String mobilephone, String workphone,
			String firstemail, String secondemail, String day, String month,
			String year, String groupname, String secondaddress,
			String secondphone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.homephone = homephone;
		this.mobilephone = mobilephone;
		this.workphone = workphone;
		this.firstemail = firstemail;
		this.secondemail = secondemail;
		this.day = day;
		this.month = month;
		this.year = year;
		this.groupname = groupname;
		this.secondaddress = secondaddress;
		this.secondphone = secondphone;
	}
}