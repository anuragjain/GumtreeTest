package com.anurag.gumtree;


public class Person {
	String first_name;
	String last_name;
	String sex;
	long dateOfBirth;


	public Person(String first_name, String last_name, String sex, long dateOfBirth) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
	}


	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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
