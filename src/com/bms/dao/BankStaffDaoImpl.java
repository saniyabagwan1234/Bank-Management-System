package com.bms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import com.bms.pojo.BankStaff;
import com.bms.utility.DBUtility;

public class BankStaffDaoImpl implements BankStaffDao {

	Connection conn;
	PreparedStatement ps;
	String query;
	Scanner sc=new Scanner(System.in);
	BankStaff b=new BankStaff();
	@Override
	public boolean addBankStaff(BankStaff b) {
		
		query="insert into BankStaff(staffName,departmentName,staffContact,staffEmailId,staffPassword,staffAddress,staffRule,staffSalary)values(?,?,?,?,?,?,?,?)";
		try {
			conn = DBUtility.establishConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, b.getStaffName());
			ps.setString(2, b.getDepartmentName());
			ps.setLong(3, b.getStaffContact());
			ps.setString(4, b.getStaffEmailId());
			ps.setString(5, b.getStaffPassword());
			ps.setString(6, b.getStaffAddress());
			ps.setString(7, b.getStaffRule());
			ps.setLong(8, b.getStaffSalary());
			
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
	public boolean updateBankStaff(BankStaff b) {
		query="update BankStaff set staffName=?,departmentName=?,staffContact=?,staffEmailId=?,staffPassword=?,staffAddress=?,staffRule=?,staffSalary=? where staffId=?";
		try {
			conn = DBUtility.establishConnection();
			ps=conn.prepareStatement(query);
			
			ps.setString(1, b.getStaffName());
			ps.setString(2, b.getDepartmentName());
			ps.setLong(3, b.getStaffContact());
			ps.setString(4, b.getStaffEmailId());
			ps.setString(5, b.getStaffPassword());
			ps.setString(6, b.getStaffAddress());
			ps.setString(7, b.getStaffRule());
			ps.setLong(8, b.getStaffSalary());
			ps.setInt(9, b.getStaffId());
			
			
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
	public boolean deleteBankStaff(int staffId) {
		query="delete from BankStaff where staffId=?";
		try {
			conn=DBUtility.establishConnection();
			ps=conn.prepareStatement(query);
			
			ps.setInt(1,staffId);
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
	public BankStaff displayBankStaffByStaffId(int staffId) {
		query="select * from BankStaff where staffId=?";
		try {
			conn=DBUtility.establishConnection();
		     
			ps=conn.prepareStatement(query);
			ps.setInt(1, staffId);
		     ResultSet rs=ps.executeQuery();
		     while(rs.next()) {
		    	 b.setStaffName(rs.getString(2));
		    	 b.setDepartmentName(rs.getString(3));
		    	b.setStaffContact(rs.getLong(4));
		    	b.setStaffEmailId(rs.getString(5));
		    	b.setStaffPassword(rs.getString(6));
		    	b.setStaffAddress(rs.getString(7));
		    	b.setStaffRule(rs.getString(8));
		    	b.setStaffSalary(rs.getLong(9));
		     }
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return b;
		
	}

	@Override
	public ArrayList<BankStaff> displayAllBankStaff() {
		query="Select * from BankStaff";
		ArrayList<BankStaff> af= new ArrayList<BankStaff>();
		try {
			conn=DBUtility.establishConnection();
			ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				BankStaff b=new BankStaff();
			b.setStaffId(rs.getInt(1));
			b.setStaffName(rs.getString(2));
	    	b.setDepartmentName(rs.getString(3));
	    	b.setStaffContact(rs.getLong(4));
	    	b.setStaffEmailId(rs.getString(5));
	    	b.setStaffPassword(rs.getString(6));
	    	b.setStaffAddress(rs.getString(7));
	    	b.setStaffRule(rs.getString(8));
	    	b.setStaffSalary(rs.getLong(9));
			
				
		    	af.add(b);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return af;
	}
}
