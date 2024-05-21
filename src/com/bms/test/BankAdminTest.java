package com.bms.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.bms.dao.BankAdminDaoImpl;
import com.bms.pojo.BankAdmin;

public class BankAdminTest {
public static void main(String[] args) {
		
		int bankadminId  ,choice;
		String bankEmailid,bankadminPassword,bankadminName,bankadminAddress;
		Long bankadminContact;
		boolean flag;
		BankAdmin ba=new BankAdmin();
		BankAdminDaoImpl bad=new BankAdminDaoImpl();
		
		Scanner sc=new Scanner(System.in);
		
		do
		{
			System.out.println("*******************WELCOME TO BankAdmin******************\n1.Add BankAdmin\n2.Update Bankadmin\n3.Delete BankAdmin\n4.Display BankAdmin By EmailId\n5.Display All BankAdmin\n6.Exit");
			System.out.println("Enter your Choice:");
			choice=sc.nextInt();
			
			
			switch(choice)
			{
			case 1:
				System.out.println("------------------Enter Below Details to add BankAdmin------------------");
				System.out.println("Enter BankAdmin Email Id");
				bankEmailid=sc.next();
				System.out.println("Enter the BankAdmin Password");
				bankadminPassword=sc.next();
				System.out.println("Enter the BankAdmin Name");
				bankadminName=sc.next();
				System.out.println("Enter the BankAdmin Address");
				bankadminAddress=sc.next();
				System.out.println("Enter the BankAdmin Contact");
				bankadminContact=sc.nextLong();
				
				
				ba.setBankAdminEmailid(bankEmailid);
				ba.setBankAdminPassword(bankadminPassword);
				ba.setBankAdminName(bankadminName);
				ba.setBankAdminAddress(bankadminAddress);
				ba.setBankAdminContact(bankadminContact);


				 flag=bad.addBankAdmin(ba);
				 
				if(flag==true)
				{
					System.out.println("BankAdmin added successfully...");
				}
				else
				{
					System.out.println("BankAdmin adding failed");
				}
				break;
				
			case 2:
				System.out.println("------------------Enter EmailId to Update BankAdmin of your choice------------------");
				System.out.println("Enter BankAdmin Email Id");
				bankEmailid=sc.next();
				
//				System.out.println("Enter the BankAdmin Id");
//				bankadminId=sc.nextInt();
				System.out.println("Enter the BankAdmin Password");
				bankadminPassword=sc.next();
				System.out.println("Enter the BankAdmin Name");
				bankadminName=sc.next();
				System.out.println("Enter the BankAdmin Address");
				bankadminAddress=sc.next();
				System.out.println("Enter the BankAdmin Contact");
				bankadminContact=sc.nextLong();
				
				   
				ba.setBankAdminEmailid(bankEmailid);
				ba.setBankAdminPassword(bankadminPassword);
				ba.setBankAdminName(bankadminName);
				ba.setBankAdminAddress(bankadminAddress);
				ba.setBankAdminContact(bankadminContact);
				
				 flag=bad.updateBankAdmin(ba);
				 
				if(flag==true)
				{
					System.out.println("BankAdmin update successfully...");
				}
				else
				{
					System.out.println("BankAdmin update failed");
				}

				break;
				
			case 3:
				System.out.println("------------------Enter EmailId to Delete BankAdmin------------------");
				System.out.println("Enter the BankAdmin EmailId");
				bankEmailid=sc.next();
				
	            flag=bad.deleteBankAdmin(bankEmailid);
				
				if(flag==true)
				{
					System.out.println("BankAdmin Delete successfully...");
				}
				else
				{
					System.out.println("BankAdmin Delete failed");
				}
				break;
				
			case 4:
				System.out.println("------------------Enter EmailId to Display Specific BankAdmin------------------");
				System.out.println("Enter the BankAdmin EmailId");
				bankEmailid=sc.next();
				
	            ba=bad.displayBankIdByBankEmailid(bankEmailid);
	            
	            System.out.println("****BankAdmin DETAILS****");
	            System.out.println(ba.getBankAdminId()+" "+ba.getBankAdminEmailid()+" "+ba.getBankAdminPassword()+" "+ba.getBankAdminName()+" "+ba.getBankAdminAddress()+" "+ba.getBankAdminContact());
				break;
	/*
	 * System.out.println("------------------Enter ID to Display Specific Food------------------");
					System.out.println("Enter the FoodId");
					foodId=sc.nextInt();
					
	                f=fd.displayFoodById(foodId);
	                
	                System.out.println("****FOOD DETAILS****");
	                System.out.println(f.getFoodName()+" "+f.getFoodType()+" "+f.getFoodCategory()+" "+f.getFoodPrice());*/
				
			case 5:
				System.out.println("------------------Existing BankAdmin Details ------------------");
				ArrayList<BankAdmin>af=new ArrayList<BankAdmin>();
				af=bad.displayAllBankAdmin();
				
				for(BankAdmin i:af)
				{
					System.out.println("BankAdmin ID:"+i.getBankAdminId());
					System.out.println("BankAdmin EmaiId:"+i.getBankAdminEmailid());
					System.out.println("BankAdmin Password:"+i.getBankAdminPassword());
					System.out.println("BankAdmin name:"+i.getBankAdminName());
					System.out.println("BankAdmin Address:"+i.getBankAdminAddress());
					System.out.println("BankAdmin Contact:"+i.getBankAdminContact());
					System.out.println();
				}
				break;
				
			case 6:
				System.out.println("Khatam Tata bye bye....Ghari jaa....");
				break;
			default:
				System.out.println("Invalid Choice...Please Enter current choice...");
				break;
			
			}
		}while(choice<6);	
		}	
}

