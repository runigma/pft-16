package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

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

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);				
	}
	
	public static List<ContactData> loadGroupsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);		
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part	= line.split(",");
			ContactData contact= new ContactData()
			 .withFirstname(part[0])
			 .withLastname(part[1])
			 .withAddress(part[2])
			 .withHomephone(part[3])
			 .withMobilephone(part[4])
			 .withWorkphone(part[5])
			 .withFirstemail(part[6])
			 .withSecondemail(part[7])
			 //.withDay(part[8])
			 //.withMonth(part[9])
			 //.withYear(part[10])
			 //.withGroupname(part[11])
			 .withSecondaddress(part[12])
			 .withSecondphone(part[13]);		
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts ){
			writer.write(contact.getFirstname() + "," + contact.getLastname() + "," + contact.getAddress() + "," 
						+ contact.getHomephone() + "," + contact.getMobilephone() + "," + contact.getWorkphone() + ","  
						+ contact.getFirstemail() + "," + contact.getSecondemail() + "," + contact.getDay() + "," 
						+ contact.getMonth() + "," + contact.getYear() + "," + contact.getGroupname() + ","  
						+ contact.getSecondaddress() + "," + contact.getSecondphone() + "!" + "\n");			
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
