package com.bms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bms.pojo.AccountHolder;
import com.bms.utility.DBUtility;

public class AccountHolderDaoImpl implements AccountHolderDao{
	
	Connection con;
	PreparedStatement ps;
	AccountHolder ah=new AccountHolder();
	String query;

	@Override
	public boolean addAccountHolder(AccountHolder ah) {
		query = "insert into AccountHolder(acctHlName, acctHlContact, acctHlAddress, acctHlBranch, acctHlIFSC, "
				+ "acctHlAdhar, acctHlPanCard, acctHlOpDate, acctHlType, acctHlBalance)"
				+ " values(?,?,?,?,?,?,?,?,?,?)";
		
		try {	
			con=DBUtility.establishConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, ah.getAcctHlName());
			ps.setLong(2, ah.getAcctHlContact());
			ps.setString(3, ah.getAcctHlAddress());
			ps.setString(4, ah.getAcctHlBranch());
			ps.setString(5, ah.getAcctHlIFSC());
			ps.setLong(6, ah.getAcctHlAdharNum());
			ps.setString(7, ah.getAcctHlPanCard());
			ps.setString(8, ah.getAcctHlOpDate());
			ps.setString(9, ah.getAcctHlType());
			ps.setLong(10, ah.getAcctHlBalance());
			
			int success=ps.executeUpdate();
			
			if(success > 0) {
				return true;
			}
			else 
			{
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateAccountHolder(AccountHolder ah) {
		query="update AccountHolder set acctHlName=?, acctHlContact=?, acctHlAddress=?, acctHlBranch=?, acctHlIFSC=?,acctHlAdhar=?, acctHlPanCard=?, acctHlOpDate=?, acctHlType=?, acctHlBalance=? where accountNumber=?";
		try {
			con = DBUtility.establishConnection();
			ps=con.prepareStatement(query);
			
			ps.setString(1,ah.getAcctHlName());
			ps.setLong(2, ah.getAcctHlContact());
			ps.setString(3, ah.getAcctHlAddress());
			ps.setString(4, ah.getAcctHlBranch());
			ps.setString(5, ah.getAcctHlIFSC());
			ps.setLong(6, ah.getAcctHlAdharNum());
			ps.setString(7, ah.getAcctHlPanCard());
			ps.setString(8, ah.getAcctHlOpDate());
			ps.setString(9, ah.getAcctHlType());
			ps.setLong(10, ah.getAcctHlBalance());
			ps.setLong(11, ah.getAccountNumber());
			
			int success=ps.executeUpdate();
			
			if(success > 0) {
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
	}
	
		return true;
	}
		

	@Override
	public boolean deleteAccountHolder(long accountNumber) {
		
		query="delete from AccountHolder where accountNumber=?";
		try {
			con=DBUtility.establishConnection();
			ps=con.prepareStatement(query);
			
			ps.setLong(1,accountNumber);
			int success=ps.executeUpdate();
			
			if(success>0) {
				return true;
			}else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return true;
	}

	

	@Override
	public AccountHolder displayAccountHolderByaccountNumber(long accountNumber) {
		
		query="select * from AccountHolder where accountNumber=?";
		try {
			con=DBUtility.establishConnection();
		     
			ps=con.prepareStatement(query);
			ps.setLong(1, accountNumber);
		     ResultSet rs=ps.executeQuery();
		     while(rs.next()) {
		    	 ah.setAcctHlName(rs.getString(2));
		    	 ah.setAcctHlContact(rs.getLong(3));
		    	 ah.setAcctHlAddress(rs.getString(4));
		    	ah.setAcctHlBranch(rs.getString(5));
		    	ah.setAcctHlIFSC(rs.getString(6));
		    	ah.setAcctHlAdharNum(rs.getLong(7));
		    	ah.setAcctHlPanCard(rs.getString(8));
		    	ah.setAcctHlOpDate(rs.getString(9));
		    	ah.setAcctHlType(rs.getString(10));
		    	ah.setAcctHlBalance(rs.getLong(11));
		     }
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return ah;
	
	}

	@Override
	public ArrayList<AccountHolder> displayAllAccountHolder() {
		
		query="Select * from AccountHolder";
		ArrayList<AccountHolder> af= new ArrayList<AccountHolder>();
		try {
			con=DBUtility.establishConnection();
			ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				AccountHolder ah=new AccountHolder();
				
				ah.setAccountNumber(rs.getLong(1));
				ah.setAcctHlName(rs.getString(2));
		    	 ah.setAcctHlContact(rs.getLong(3));
		    	 ah.setAcctHlAddress(rs.getString(4));
		    	ah.setAcctHlBranch(rs.getString(5));
		    	ah.setAcctHlIFSC(rs.getString(6));
		    	ah.setAcctHlAdharNum(rs.getLong(7));
		    	ah.setAcctHlPanCard(rs.getString(8));
		    	ah.setAcctHlOpDate(rs.getString(9));
		    	ah.setAcctHlType(rs.getString(10));
		    	ah.setAcctHlBalance(rs.getLong(11));
		    	
		    	af.add(ah);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return af;
	}
	}

	

