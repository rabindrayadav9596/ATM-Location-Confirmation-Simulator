package com.jon.service;

import java.util.List;

import com.jon.model.Customer;

public interface CustomerDao {
	
	boolean addCustomer(Customer c);
	Customer countCustomer(String address);
	Customer countTransaction(String address);
	List<Customer> viewDetails(String address);
	
	

}
