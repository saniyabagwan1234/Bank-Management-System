package com.bms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.bms.pojo.Transaction;
import com.bms.utility.DBUtility;

public  class TransactionDaoImpl implements TransactionDao{

	Connection con;
	PreparedStatement ps;
	String query;
	String transactionType;
	Scanner sc=new Scanner(System.in);
	Transaction tr=new Transaction();
	ResultSet rs;
	
	
	@Override
	public boolean accountExists(long accountNumber) {
		query="Select accountNumber from accountHolder where accountNumber=?";
		try {
			con=DBUtility.establishConnection();
			ps=con.prepareStatement(query);
			ps.setLong(1, accountNumber);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public long checkBalance(long accountNumber) {
		
		query="Select acctHlBalance from accountHolder where accountNumber=?";
		try {
			con=DBUtility.establishConnection();
			ps=con.prepareStatement(query);
			ps.setLong(1, accountNumber);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				long balance=rs.getLong(1);
				return balance;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public boolean beginTransaction(Transaction tr) {
		query="insert into Transaction(accountNumber,transactionType,transactionDate,amount)values(?,?,?,?)";
		try {
			con=DBUtility.establishConnection();
			ps=con.prepareStatement(query);
			ps.setLong(1, tr.getAccountNumber());
			ps.setString(2, tr.getTransactionType());
			ps.setString(3, tr.getTransactionDate());
			ps.setDouble(4, tr.getAmount());
			
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
	public Transaction displayTransaction(int id) {
		
		query="select * from Transaction where  transactionId=?";
		
		try {
			con=DBUtility.establishConnection();
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				tr.setTransactionType(rs.getString(2));
				tr.setTransactionDate(rs.getString(3));
				tr.setAmount(rs.getDouble(4));
				tr.setAccountNumber(rs.getLong(5));
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tr;
		
		
	}
	@Override
	public Transaction displayTransaction(long accountNumber) {
query="select * from Transaction where  accountNumber=?";
		
		try {
			con=DBUtility.establishConnection();
			ps=con.prepareStatement(query);
			ps.setLong(1, accountNumber);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				tr.setTransactionType(rs.getString(2));
				tr.setTransactionDate(rs.getString(3));
				tr.setAmount(rs.getDouble(4));
				tr.setTransactionId(rs.getInt(5));
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tr;
	}
	@Override
	public ArrayList<Transaction> ShowAllTransaction() {
		query="Select * from Transaction";
		ArrayList<Transaction> af= new ArrayList<Transaction>();
		try {
			con=DBUtility.establishConnection();
			ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				Transaction tr=new Transaction();
				tr.setTransactionId(rs.getInt(1));
				tr.setTransactionType(rs.getString(2));
				tr.setTransactionDate(rs.getString(3));
				tr.setAmount(rs.getDouble(4));	
				tr.setAccountNumber(rs.getLong(5));
		    	af.add(tr);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return af;
	}
	
	
	
	
}
