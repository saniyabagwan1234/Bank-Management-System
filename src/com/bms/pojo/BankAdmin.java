package com.bms.pojo;

public class BankAdmin {
 private int bankAdminId;
 private String bankAdminEmailid,bankAdminPassword,bankAdminName,bankAdminAddress;
 public String getBankAdminPassword() {
	return bankAdminPassword;
}
public void setBankAdminPassword(String bankAdminPassword) {
	this.bankAdminPassword = bankAdminPassword;
}
private Long bankAdminContact;
public int getBankAdminId() {
	return bankAdminId;
}
public void setBankAdminId(int bankAdminId) {
	this.bankAdminId = bankAdminId;
}
public String getBankAdminEmailid() {
	return bankAdminEmailid;
}
public void setBankAdminEmailid(String bankAdminEmailid) {
	this.bankAdminEmailid = bankAdminEmailid;
}
public String getBankAdminName() {
	return bankAdminName;
}
public void setBankAdminName(String bankAdminName) {
	this.bankAdminName = bankAdminName;
}
public String getBankAdminAddress() {
	return bankAdminAddress;
}
public void setBankAdminAddress(String bankAdminAddress) {
	this.bankAdminAddress = bankAdminAddress;
}
public Long getBankAdminContact() {
	return bankAdminContact;
}
public void setBankAdminContact(Long bankAdminContact) {
	this.bankAdminContact = bankAdminContact;
}
 
}
