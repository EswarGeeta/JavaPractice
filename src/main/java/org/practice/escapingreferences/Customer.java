package org.practice.escapingreferences;

public class Customer {
	private String name;

	public String getName() {
		return name;
	}

	public Customer(String name) {
		this.name = name;
	}

	//Use this copy constructor to return a copy of element when needed.
	public Customer(Customer c) {
		this.name = c.getName();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
	
}
