package com.gmail.ndonskih63;

public class Human {
	
	private String surname;
	private String name;
	private int age;
	private String sex;
	
	public Human(String surname, String name, int age, String sex) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.sex = sex;
	}
	public Human() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	public String toString() {
		return surname + name + ", age: " + age + ", sex: " + sex;
	}
	
}
