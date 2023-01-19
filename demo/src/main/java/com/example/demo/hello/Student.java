package com.example.demo.hello;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private String name;
	private int age;
	private String location;

	//default constructor
	public Student(){}

	public Student(String n, int a, String l) {
		name = n;
		age = a;
		location =l;
	}
	
	public String getName() {return name;}
	public int getAge() {return age;}
	public String getLocation() {return location;}
	
}
