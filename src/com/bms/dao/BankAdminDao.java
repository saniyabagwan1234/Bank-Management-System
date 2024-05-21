package com.bms.dao;

import java.util.ArrayList;

import com.bms.pojo.BankAdmin;

public interface BankAdminDao {

	boolean addBankAdmin(BankAdmin ba);
	boolean updateBankAdmin(BankAdmin ba);
	boolean deleteBankAdmin(String bankAdminEmailid);
	BankAdmin displayBankIdByBankEmailid(String bankAdminEmailid);
	ArrayList <BankAdmin> displayAllBankAdmin();
}
