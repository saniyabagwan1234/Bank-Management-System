package com.bms.pojo;

public class Transaction {
private int transactionId;
private String transactionType,transactionDate;
private double amount;
private long accountNumber;

public int getTransactionId() {
	return transactionId;
}
public void setTransactionId(int transactionId) {
	this.transactionId = transactionId;
}

public String getTransactionDate() {
	return transactionDate;
}
public void setTransactionDate(String transactionDates) {
	transactionDate = transactionDates;
}

public long getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(long accountNumber) {
	this.accountNumber = accountNumber;
}
public String getTransactionType() {
	return transactionType;
}
public void setTransactionType(String transactionType) {
	this.transactionType = transactionType;
}

public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
}
