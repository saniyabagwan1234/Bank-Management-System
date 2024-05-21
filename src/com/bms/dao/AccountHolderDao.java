package com.bms.dao;

import java.util.ArrayList;

import com.bms.pojo.AccountHolder;

public interface AccountHolderDao {

	boolean addAccountHolder(AccountHolder ah);
	boolean updateAccountHolder(AccountHolder ah);
	boolean deleteAccountHolder(long accountNumber);
	AccountHolder displayAccountHolderByaccountNumber(long accountNumber);
	ArrayList<AccountHolder>displayAllAccountHolder();
}
