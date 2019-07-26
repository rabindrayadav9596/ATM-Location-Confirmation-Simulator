package com.jon.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jon.db.DB;
import com.jon.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
	Connection con = null;
	
	public CustomerDaoImpl() {
		con = DB.getDbCon();
	}

	@Override
	public boolean addCustomer(Customer c) {
		String sql = "insert into customer(accountnumber,name,address,numberoftransaction)values(?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, c.getAccountnumber());
			pstm.setString(2, c.getName());
			pstm.setString(3, c.getAddress());
			pstm.setInt(4, c.getNumberOfTransaction());
			pstm.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public List<Customer> viewDetails(String address) {
		List<Customer> clist = new ArrayList<>();
		String sql = "SELECT * from customer where address = '"+address+"' " ;
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				Customer c = new Customer();
				c.setAccountnumber(rs.getInt("accountnumber"));
				c.setName(rs.getString("name"));
				c.setAddress(rs.getString("address"));
				c.setNumberOfTransaction(rs.getInt("numberoftransaction"));
				
				clist.add(c);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clist;
	}

	@Override
	public Customer countCustomer(String address) {
		Customer c = new Customer();
		String sql = "Select address, count(*) as totalcustomer from customer group by address having address ='"+address+"'";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				c.setCount(rs.getInt("totalcustomer"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	public Customer countTransaction(String address) {
		Customer c = new Customer();
		String sql = "Select address, sum(numberoftransaction) as total from customer group by address having address ='"+address+"'";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				
				c.setNumberOfTransaction(rs.getInt("total"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
		
	}
	
	}

	



