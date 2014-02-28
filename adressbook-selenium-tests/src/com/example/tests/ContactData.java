package com.example.tests;

public class ContactData implements Comparable<ContactData> {
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
}