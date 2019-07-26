package com.jon.model;

public class Customer {
	private int accountnumber;
	private int numberOfTransaction = 0;
	public int getNumberOfTransaction() {
		return numberOfTransaction;
	}
	public void setNumberOfTransaction(int numberOfTransaction) {
		this.numberOfTransaction = numberOfTransaction;
	}
	private String name;
	private String address;
	private String selectedAdress;
	private int count= 0;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getSelectedAdress() {
		return selectedAdress;
	}
	public void setSelectedAdress(String selectedAdress) {
		this.selectedAdress = selectedAdress;
	}
	private int numberByLocation ;
	
	
	
	public int getNumberByLocation() {
		return numberByLocation;
	}
	public void setNumberByLocation(int numberByLocation) {
		this.numberByLocation = numberByLocation;
	}
	public int getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
