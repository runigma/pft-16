package com.example.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3){
			System.out.println("Please specify parameters: <amount of test data> <file> <format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2]; 
		
		if (file.exists()) {
			System.out.println("File exists, plese remove it manually: " + file);	
			return;
		}
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format " + format);
			return;
		}
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) {
		// TODO Auto-generated method stub
		
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts ){
			writer.write(contact.getFirstname() + "," + contact.getLastname() + "," + contact.getAddress() + "," 
						+ contact.getHomephone() + "," + contact.getMobilephone() + "," + contact.getWorkphone() + ","  
						+ contact.getFirstemail() + "," + contact.getSecondemail() + "," + contact.getDay() + "," 
						+ contact.getMonth() + "," + contact.getYear() + "," + contact.getGroupname() + ","  
						+ contact.getSecondaddress() + "," + contact.getSecondphone() + "\n");			
		}
		writer.close(); 
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();		
		for (int i = 0; i < amount; i++)
		{
			ContactData contact = new ContactData()
			 .withFirstname(generateRandomString())
			 .withLastname(generateRandomString())
			 .withAddress(generateRandomString())
			 .withHomephone(generateRandomString())
			 .withMobilephone(generateRandomString())
			 .withWorkphone(generateRandomString())
			 .withFirstemail(generateRandomString())
			 .withSecondemail(generateRandomString())
			 //.withDay(generateRandomString())
			 //.withMonth(generateRandomString())
			 //.withYear(generateRandomString())
			 //.withGroupname(generateRandomString())
			 .withSecondaddress(generateRandomString())
			 .withSecondphone(generateRandomString());			
			list.add(contact);
		}
		return list;		
	}
	
	public static String generateRandomString(){
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}		
	}

}
