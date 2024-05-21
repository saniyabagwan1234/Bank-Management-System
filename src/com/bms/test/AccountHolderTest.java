package com.bms.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.bms.dao.AccountHolderDaoImpl;
import com.bms.pojo.AccountHolder;

public class AccountHolderTest {
public static void main(String[] args) {
	
	AccountHolder ah=new AccountHolder();
	AccountHolderDaoImpl ahd=new AccountHolderDaoImpl(); 
	String acctHlName,acctHlBranch, acctHlIFSC,acctHlPanCard,acctHlOpDate,acctHlAddress,acctHlType;
	long acctHlContact,acctHlBalance,acctHlAdhar,accountNumber;
	boolean flag;
	Scanner sc=new Scanner(System.in);
	int choice;
		
	
	do 
	{
		System.out.println("****************************Welcome To SBI BANK*******************************\n1.Add Account\n2.Update Account\n3.Delete Account\n4.Display Account By AccountNumber\n5.Display All Account\n6.Exit");
		System.out.println("Enter Your Choice: ");
		choice=sc.nextInt();
		
		switch(choice) {
		case 1 :
			System.out.println("--------------------ENTER BELOW DETAILS TO ADD Account---------------------------");
			System.out.println("Enter Account Holder Name: ");
			acctHlName=sc.next();
			System.out.println("Enter Account Holder Contact: ");
			acctHlContact=sc.nextLong();
			System.out.println("Enter Account Holder Address: ");
			acctHlAddress=sc.next();
			System.out.println("Enter Account Branch: ");
			acctHlBranch=sc.next();
			System.out.println("Enter Account Holder IFSC Code: ");
			acctHlIFSC=sc.next();
			System.out.println("Enter Adhar Number: ");
			acctHlAdhar=sc.nextLong();
			System.out.println("Enter Pan Card ID: ");
			acctHlPanCard=sc.next();
			System.out.println("Enter Account Open Date: ");
			acctHlOpDate=sc.next();
			System.out.println("Enter Account Type: ");
			acctHlType=sc.next();
			System.out.println("Enter Account Balance: ");
			acctHlBalance=sc.nextLong();
			
			ah.setAcctHlName(acctHlName);
			ah.setAcctHlContact(acctHlContact);
			ah.setAcctHlAddress(acctHlAddress);
			ah.setAcctHlBranch(acctHlBranch);
			ah.setAcctHlIFSC(acctHlIFSC);
			ah.setAcctHlAdharNum(acctHlAdhar);
			ah.setAcctHlPanCard(acctHlPanCard);
			ah.setAcctHlOpDate(acctHlOpDate);
			ah.setAcctHlType(acctHlType);
			ah.setAcctHlBalance(acctHlBalance);
            
            flag=ahd.addAccountHolder(ah);
            if(flag==true) {
            	System.out.println("Account added Successfully....");
            }
            else {
            	System.out.println("Account added Failed...");
            }
			break;
		case 2 :
			System.out.println("--------------------ENTER ID TO UPDATE DETAILS OF YOUR CHOICE---------------------------");
			
			System.out.println("Enter Account Number: ");
			accountNumber=sc.nextLong();
			System.out.println("Enter Account Holder Name: ");
			acctHlName=sc.next();
			System.out.println("Enter Account Holder Contact: ");
			acctHlContact=sc.nextLong();
			System.out.println("Enter Account Holder Address: ");
			acctHlAddress=sc.next();
			System.out.println("Enter Account Branch: ");
			acctHlBranch=sc.next();
			System.out.println("Enter Account Holder IFSC Code: ");
			acctHlIFSC=sc.next();
			System.out.println("Enter Adhar Number: ");
			acctHlAdhar=sc.nextLong();
			System.out.println("Enter Pan Card ID: ");
			acctHlPanCard=sc.next();
			System.out.println("Enter Account Open Date: ");
			acctHlOpDate=sc.next();
			System.out.println("Enter Account Type: ");
			acctHlType=sc.next();
			System.out.println("Enter Account Balance: ");
			acctHlBalance=sc.nextLong();
			
			ah.setAccountNumber(accountNumber);
			ah.setAcctHlName(acctHlName);
			ah.setAcctHlContact(acctHlContact);
			ah.setAcctHlAddress(acctHlAddress);
			ah.setAcctHlBranch(acctHlBranch);
			ah.setAcctHlIFSC(acctHlIFSC);
			ah.setAcctHlAdharNum(acctHlAdhar);
			ah.setAcctHlPanCard(acctHlPanCard);
			ah.setAcctHlOpDate(acctHlOpDate);
			ah.setAcctHlType(acctHlType);
			ah.setAcctHlBalance(acctHlBalance);
           flag=ahd.updateAccountHolder(ah);
           
          // System.out.println(flag);
            if(flag==true) {
            	System.out.println("Account Update Successfully....");
            }
            else {
            	System.out.println("Account Update Failed...");
            }
			break;
		case 3 :
			System.out.println("--------------------ENTER ID TO DELETE Account---------------------------");
			System.out.println("Enter Account Number: ");
			accountNumber=sc.nextInt();
			
			
			flag=ahd.deleteAccountHolder(accountNumber);
			
			if(flag==true) {
				System.out.println("Account Delete Successfully");
			}else {
				System.out.println("Account Delete Failed..");
			}
			break;
		case 4 :
			System.out.println("--------------------ENTER ID TO DISPLAY SPECIFIC Account---------------------------");
			System.out.println("Enter Account Number: ");
			accountNumber=sc.nextInt();
			
			ah=ahd.displayAccountHolderByaccountNumber(accountNumber);
		System.out.println("***********Account Details**************");
		System.out.println(ah.getAcctHlName()+" "+ah.getAcctHlContact()+" "+ah.getAcctHlAddress()+" "+ah.getAcctHlBranch()+" "+ah.getAcctHlIFSC()+" "+ah.getAcctHlAdharNum()+" "+ah.getAcctHlPanCard()+" "+ah.getAcctHlOpDate()+" "+ah.getAcctHlType()+" "+ah.getAcctHlBalance());
			
			break;
		case 5 :
			System.out.println("--------------------EXISTING Account DETAILS---------------------------");
			
			ArrayList<AccountHolder> af=new ArrayList<AccountHolder>();
			af=ahd.displayAllAccountHolder();
			
			for(AccountHolder i:af) {
				System.out.println("Account Number: "+i.getAccountNumber());
				System.out.println("Account Holder Name: "+i.getAcctHlName());
				System.out.println("Account Holder Contact: "+i.getAcctHlContact());
				System.out.println("Account Holder Address: "+i.getAcctHlAddress());
				System.out.println("Account Holder Branch: "+i.getAcctHlBranch());
				System.out.println("Account Holder IFSC: "+i.getAcctHlIFSC());
				System.out.println("Account Holder Adhar Number: "+i.getAcctHlAdharNum());
				System.out.println("Account Holder Pan Card: "+i.getAcctHlPanCard());
				System.out.println("Account Holder Open Date: "+i.getAcctHlOpDate());
				System.out.println("Account Holder Type: "+i.getAcctHlType());
				System.out.println("Account Holder Balance: "+i.getAcctHlBalance());
				
				System.out.println();
			}
			
			break;
		case 6:
			System.out.println("Khatam Tata bye bye....Ghari jaa.....");
			break;
		default:
			System.out.println("Invalid choice...Please Enter Correct Choice...");
		}
		
	}while(choice<7);
}
}

