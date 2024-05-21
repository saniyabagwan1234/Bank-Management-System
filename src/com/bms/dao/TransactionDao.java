package com.bms.dao;

import java.util.ArrayList;
import java.util.List;

import com.bms.pojo.Transaction;

public interface TransactionDao{
	
	boolean accountExists(long accountNumber);
	
	long checkBalance(long accountNumber);
	
	boolean beginTransaction(Transaction tr);
	
	Transaction displayTransaction(int id);
	
	Transaction displayTransaction(long accountNumber);
	
	ArrayList <Transaction> ShowAllTransaction();
	
	
	
}
