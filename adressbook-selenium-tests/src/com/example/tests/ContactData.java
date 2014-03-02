package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String firstname;
	private String lastname;
	private String address;
	private String homephone;
	private String mobilephone;
	private String workphone;
	private String firstemail;
	private String secondemail;
	private String day;
	private String month;
	private String year;
	private String groupname;
	private String secondaddress;
	private String secondphone;

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
	



	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname
				+ "]";
	}

	@Override
	public int hashCode() {
		//final int prime = 31;
		int result = 1;
		//result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		int cmp;
		cmp = this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
		if (cmp==0){
			cmp = this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
		}
		return cmp;
	}

	public ContactData withFirstname(String firstname) {
		this.firstname =firstname;
		return this;
	}

	public ContactData withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withHomephone(String homephone) {
		this.homephone = homephone;
		return this;
	}

	public ContactData withMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
		return this;
	}

	public ContactData withWorkphone(String workphone) {
		this.workphone = workphone;
		return this;
	}

	public ContactData withFirstemail(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public ContactData withSecondemail(String secondemail) {
		this.secondemail = secondemail;
		return this;
	}

	public ContactData withSecondaddress(String secondaddress) {
		this.secondaddress = secondaddress;
		return this;
	}

	public ContactData withSecondphone(String secondphone) {
		this.secondphone = secondphone;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress() {
		return address;
	}

	public String getHomephone() {
		return homephone;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public String getWorkphone() {
		return workphone;
	}

	public String getFirstemail() {
		return firstemail;
	}

	public String getSecondemail() {
		return secondemail;
	}

	public String getDay() {
		return day;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	public String getGroupname() {
		return groupname;
	}

	public String getSecondaddress() {
		return secondaddress;
	}

	public String getSecondphone() {
		return secondphone;
	}
	
	
	
}