package com.anurag.gumtree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

	List<Person> persons = new ArrayList<Person>();

	public static void main(String[] args) {
		Main m = new Main();
		m.readData();
		System.out.println("Number of Males: "+m.getNumOfMales());
		System.out.println("Oldest Person: "+m.getOldestPerson());
		System.out.println("Bill is older than Paul by "+m.getDaysDiffPaulBill()+" days");
	}

	public int getNumOfMales(){
		int count = 0;
		for(Person p:persons){
			if(p.getSex().equalsIgnoreCase("male"))
				count++;
		}
		return count;
	}

	public String getOldestPerson(){
		String out = "";
		long date = new Date().getTime();
		for(Person p:persons){
			if(p.getDateOfBirth()<date){
				date = p.getDateOfBirth();
				out = p.getFirst_name()+" "+p.getLast_name();
			}
		}
		return out;
	}

	public int getDaysDiffPaulBill(){
		long dob_paul = 0;
		long dob_bill = 0;
		for(Person p:persons){
			if(p.getFirst_name().equalsIgnoreCase("paul"))
				dob_paul = p.getDateOfBirth();
			if(p.getFirst_name().equalsIgnoreCase("bill"))
				dob_bill = p.getDateOfBirth();
		}
		int diff = (int) ((dob_paul-dob_bill)/(1000*3600*24));
		return diff;
	}

	public void readData(){
		try {
			URL url = getClass().getResource("AddressBook");
			FileInputStream fis = new FileInputStream(new File(url.getPath()));
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
			String line;
			while ((line = reader.readLine()) != null){
				String[] temp = line.split(",");
				String[] name = temp[0].split(" ");
				String dob = temp[2].trim();
				Person p = new Person(name[0].trim(),name[1].trim(), temp[1].trim().toLowerCase(), formatter.parse(dob).getTime());
				persons.add(p);
			}
			reader.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
