package com.anurag.gumtree;


public class Person {
	String name;
	String sex;
	long dateOfBirth;


	public Person(String name, String sex, long dateOfBirth) {
		super();
		this.name = name;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public long getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(long dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


}
