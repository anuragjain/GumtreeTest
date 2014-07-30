package com.anurag.gumtree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

	List<Person> persons = new ArrayList<Person>();

	public static void main(int arg, String[] args){
		Main m = new Main();
		m.readData();
	}

	public int getNumOfMales(){
		int count = 0;
		for(Person p:persons){
			if(p.getSex().equalsIgnoreCase("male"))
				count++;
		}
		return count;
	}
		
	public void readData(){
		try {
			FileInputStream fis = new FileInputStream(new File("/AddressBook"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
			String line;
			while ((line = reader.readLine()) != null){
				String[] temp = line.split(",");
				String dob = temp[2].trim();
				Person p = new Person(temp[0].trim(), temp[1].trim().toLowerCase(), formatter.parse(dob).getTime());
				persons.add(p);
			}
			reader.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
