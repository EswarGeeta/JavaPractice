package org.practice.escapingreferences;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CustomerRecords {
	private final Map<String, Customer> records;
	
	public CustomerRecords() {
		this.records = new HashMap<String, Customer>();
	}
	
	public void addCustomer(Customer c) {
		this.records.put(c.getName(), c);
	}
		
	public Map<String, Customer> getCustomers() {
		return Collections.unmodifiableMap(records);
	}

	public Customer findCustomer(String name) {

		// This returns the actual object.
		// return records.get(name);

		//this returns a copy of the object.
		return new Customer(records.get(name));
	}
}
