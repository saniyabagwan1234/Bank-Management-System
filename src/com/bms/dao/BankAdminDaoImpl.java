package com.bms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bms.pojo.AccountHolder;
import com.bms.pojo.BankAdmin;
import com.bms.utility.DBUtility;

public class BankAdminDaoImpl implements BankAdminDao {

	String query;
	Connection con;
	PreparedStatement ps;
	BankAdmin ba=new BankAdmin();
	
	@Override
	public boolean addBankAdmin(BankAdmin ba) {
	query="insert into BankAdmin(bankEmailid,bankAdminPassword,bankAdminName,bankAdminAddress,bankAdminContact)values(?,?,?,?,?)";
	
	try {
		con=DBUtility.establishConnection();
		ps=con.prepareStatement(query);
		
		ps.setString(1, ba.getBankAdminEmailid());
		ps.setString(2, ba.getBankAdminPassword());
		ps.setString(3, ba.getBankAdminName());
		ps.setString(4, ba.getBankAdminAddress());
		ps.setLong(5, ba.getBankAdminContact());
		
		int success=ps.executeUpdate();
		if(success>0) {
			return true;
		}else
		{
			return false;
		}
		
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
		return true;
	}

	@Override
	public boolean updateBankAdmin(BankAdmin ba) {
		
		query="update BankAdmin set bankAdminPassword=?, bankAdminName=?, bankAdminAddress=?, bankAdminContact=? where bankEmailid=?";
		
		try {
			con=DBUtility.establishConnection();
			ps=con.prepareStatement(query);
			
			ps.setString(1, ba.getBankAdminPassword());
			ps.setString(2, ba.getBankAdminName());
			ps.setString(3, ba.getBankAdminAddress());
			ps.setLong(4, ba.getBankAdminContact());
			ps.setString(5, ba.getBankAdminEmailid());
			
			int success=ps.executeUpdate();
			if(success>0) {
				return true;
			}else
			{
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	
		return true;
	}

	@Override
	public boolean deleteBankAdmin(String bankEmailid) {
		
		query="delete from BankAdmin where bankEmailid=?";
		
		try {
			con=DBUtility.establishConnection();
			ps=con.prepareStatement(query);
			
			ps.setString(1, bankEmailid);
			int success=ps.executeUpdate();
			
			if(success>0) {
				return true;
			}else
			{
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public BankAdmin displayBankIdByBankEmailid(String bankEmailid) {
		
		query="select * from BankAdmin where bankEmailid=?";
				
		try {
			con=DBUtility.establishConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, bankEmailid);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				ba.setBankAdminId(rs.getInt(1));
				ba.setBankAdminEmailid(rs.getString(2));
				ba.setBankAdminPassword(rs.getString(3));
				ba.setBankAdminName(rs.getString(4));
				ba.setBankAdminAddress(rs.getString(5));
				ba.setBankAdminContact(rs.getLong(6));
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return ba;
	}

	@Override
	public ArrayList<BankAdmin> displayAllBankAdmin() {
		
		query="Select * from BankAdmin";
		ArrayList<BankAdmin> af= new ArrayList<BankAdmin>();
		try {
			con=DBUtility.establishConnection();
			ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				BankAdmin ah=new BankAdmin();
				
				ba.setBankAdminId(rs.getInt(1));
				ba.setBankAdminEmailid(rs.getString(2));
				ba.setBankAdminPassword(rs.getString(3));
				ba.setBankAdminName(rs.getString(4));
				ba.setBankAdminAddress(rs.getString(5));
				ba.setBankAdminContact(rs.getLong(6));
		    	
		    	af.add(ba);
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return af;	
	} 
}
