package com.bms.test;

//import java.util.Date;
//import java.util.Scanner;
//
//import com.bms.dao.TransactionDaoImpl;
//import com.bms.pojo.Transaction;
//
//public class TransactionTest {
//
//////	public static void main(String[] args) {
//////		
//////		int choice;
//////		String query;
//////		Transaction tr= new Transaction();
//////		TransactionDaoImpl td=new TransactionDaoImpl();
//////		boolean flag;
//////		long accountNumber;
//////		String transactionType,transactionDate;
//////		int amount;
//////		transactionDate=new Date().toString();
//////		
//////		Scanner sc=new Scanner(System.in);
//////		do {
//////			System.out.println("1.Start Transaction\n2.Display Transaction By Id\n3.Display Transactionby Account Number\n4.Display All transactions\n5.Exit\nEnter your Choice:");
//////			choice=sc.nextInt();
//////			
//////			switch(choice) {
//////			case 1:
//////				System.out.println("Enter Account Number: ");
//////				accountNumber=sc.nextLong();
//////				flag=td.accountExists(accountNumber);
//////				if(flag==true) {
//////					System.out.println("Select Type of Transaction:(Press 'CB')for Balance Enquiry,'DB'for Debit and 'CR'for Credit");
//////					transactionType=sc.next();
//////					if(transactionType.equals("CB")) {
//////						
//////					}
//////				}
//////			}
//////		}while(choice>5);
////	}
//	
//
//}

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.bms.dao.TransactionDaoImpl;

import com.bms.pojo.Transaction;

public class TransactionTest {
	
	public static void main(String[] args) {
		
		int choice;
		String query;
		Transaction t =  new Transaction();
		TransactionDaoImpl td = new TransactionDaoImpl();
		boolean flag;
		long accountNumber;
		String transactionType,transactionDate;
		int amount,transactionId;
		transactionDate = new Date().toString();
		
		
		Scanner sc = new Scanner(System.in);
		
		do
		{
		System.out.println("1. Start Transaction\n2. Display Transaction By Id\n3. Display Transaction by Account Number\n4. Display All transactions\n5. Exit\nEnter your choice:");
		
		choice =  sc.nextInt();
		
		switch(choice)
		{
		case 1:
			
			System.out.println("Enter account Number:");
			accountNumber = sc.nextLong();
			flag = td.accountExists(accountNumber);
	if(flag == true)
	{
			System.out.println("Select Type of Transaction:(Press 'CB' for Balance Enquiry ,'DB' for Debit and 'CR' for Credit)");
			transactionType =  sc.next();
			
			if(transactionType.equals("CB"))
			{
//				System.out.println("Enter account Number:");
//				accountNumber = sc.nextLong();
				long balance = td.checkBalance(accountNumber);
				System.out.println("Your available balance is: " +balance);
				System.exit(0);
				
			}
			else if(transactionType.equals("DB")) //withdraw 
			{
				
				System.out.println("Enter amount to Withdrawal");
				amount =  sc.nextInt();
				
				t.setAccountNumber(accountNumber);
				t.setTransactionType(transactionType);
				t.setTransactionDate(transactionDate);
				t.setAmount(amount);
				
				flag = td.beginTransaction(t);
				
				if(flag == true)
				{
					System.out.println("Transaction successful :)");
				}
				else
				{
					System.out.println("Something went wrong :");
				}
				
				
			}
			else if(transactionType.equals("CR"))
			{
				
				
				System.out.println("Enter amount to Deposit");
				amount =  sc.nextInt();
				
				t.setAccountNumber(accountNumber);
				t.setTransactionType(transactionType);
				
				t.setTransactionDate(transactionDate);
				t.setAmount(amount);
				
				flag = td.beginTransaction(t);
				
				if(flag == true)
				{
					System.out.println("Transaction successful :)");
				}
				else
				{
					System.out.println("Something went wrong :");
				}
				
			}
			else
			{
				System.out.println("Invalid choice...Checkup karke aao...");
			}
			
}
else
{
		System.out.println("Account does'nt exist...:(");
}
			
			break;
		
		case 2:
			System.out.println("------------------Enter ID to Display Specific Transaction------------------");
			System.out.println("Enter the Trasaction Id");
			transactionId=sc.nextInt();
			
            t=td.displayTransaction(transactionId);
            
            System.out.println("Staff DETAILS");
            System.out.println(t.getAccountNumber()+" "+t.getTransactionType()+" "+t.getTransactionDate()+" "+t.getAmount());
			break;
		
		case 3:
			System.out.println("------------------Enter ID to Display Specific Transaction------------------");
			System.out.println("Enter the account Number");
			accountNumber=sc.nextLong();
			
            t=td.displayTransaction(accountNumber);
            
            System.out.println("Staff DETAILS");
            System.out.println(t.getTransactionId()+" "+t.getAccountNumber()+" "+t.getTransactionType()+" "+t.getTransactionDate()+" "+t.getAmount());
			break;

			
		case 4:
			System.out.println("------------------Existing Account Details ------------------");
			ArrayList<Transaction>af=new ArrayList<Transaction>();
			af=td.ShowAllTransaction();
			
			for(Transaction i:af)
			{
				System.out.println("Transaction id:"+i.getTransactionId());
				System.out.println("Account Number:"+i.getAccountNumber());
				System.out.println("Transaction Type:"+i.getTransactionType());
				System.out.println("Transaction Date:"+i.getTransactionDate());
				System.out.println("Transaction Amount:"+i.getAmount());
				System.out.println();
			}
			
			break;
			
		case 5:
			System.out.println("BYE BYE");
			break;
		default:
			System.out.println("Invalid choice");
			
		}
		}
		while(choice<5);
	}

}