package org.practice.escapingreferences;

public class Main {

	public static void main(String[] args) {
		CustomerRecords records = new CustomerRecords();

		records.addCustomer(new Customer("John"));
		records.addCustomer(new Customer("Simon"));

		// Below code throws exception as this is unmodifiable map.
		// records.getCustomers().clear();

		// But below code can change the value inside a customer. This unmodifiable map make sure that we can not add or remove elements from map.
		// Create a copy constructor in Customer class and return a copy of object from find method rather than returning the original object.
		Customer customerJohn = records.findCustomer("John");
		customerJohn.setName("Not John");

		for (Customer next : records.getCustomers().values())
				{
					System.out.println(next);
				}

	}
	
}
