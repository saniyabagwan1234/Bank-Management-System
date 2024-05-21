package com.bms.dao;

import java.util.ArrayList;

import com.bms.pojo.BankStaff;

public interface BankStaffDao {
	boolean addBankStaff(BankStaff b);
	
	boolean updateBankStaff(BankStaff b);
	
	boolean deleteBankStaff(int staffId);
	
	BankStaff displayBankStaffByStaffId(int staffId);
	
	ArrayList <BankStaff> displayAllBankStaff();

	
}
