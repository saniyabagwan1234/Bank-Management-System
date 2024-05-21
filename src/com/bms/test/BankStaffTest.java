package com.bms.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.bms.dao.BankStaffDao;
import com.bms.dao.BankStaffDaoImpl;
import com.bms.pojo.BankStaff;

public class BankStaffTest {
	public static void main(String[] args) {
		
		BankStaff b=new BankStaff();
		BankStaffDaoImpl bs=new BankStaffDaoImpl(); 
		String staffName,departmentName,staffRule,staffPassword,staffEmailId,staffAddress;
		long staffSalary,staffContact;
		int staffId;
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
				System.out.println("--------------------ENTER BELOW DETAILS TO ADD Staff---------------------------");
				System.out.println("Enter Staff Name: ");
				staffName=sc.next();
				System.out.println("Enter Department Name: ");
				departmentName=sc.next();
				System.out.println("Enter Staff Contact: ");
				staffContact=sc.nextLong();
				System.out.println("Enter Email Id: ");
				staffEmailId=sc.next();
				System.out.println("Enter Password: ");
				staffPassword=sc.next();
				System.out.println("Enter Staff Address: ");
				staffAddress=sc.next();
				System.out.println("Enter Staff Rule: ");
				staffRule=sc.next();
				System.out.println("Enter Staff Salary: ");
				staffSalary=sc.nextLong();
				
				
				b.setStaffName(staffName);
				b.setDepartmentName(departmentName);
				b.setStaffContact(staffContact);
				b.setStaffEmailId(staffEmailId);
				b.setStaffPassword(staffPassword);
				b.setStaffAddress(staffAddress);
				b.setStaffRule(staffRule);
				b.setStaffSalary(staffSalary);
				
	            
	            flag=bs.addBankStaff(b);
	            if(flag==true) {
	            	System.out.println("Staff added Successfully....");
	            }
	            else {
	            	System.out.println("Staff added Failed...");
	            }
				break;
			case 2 :
				System.out.println("--------------------ENTER ID TO UPDATE DETAILS OF YOUR CHOICE---------------------------");
				
				System.out.println("Enter Staff ID: ");
				staffId=sc.nextInt();
				System.out.println("Enter Staff Name: ");
				staffName=sc.next();
				System.out.println("Enter Department Name: ");
				departmentName=sc.next();
				System.out.println("Enter Staff Contact: ");
				staffContact=sc.nextLong();
				System.out.println("Enter Email Id: ");
				staffEmailId=sc.next();
				System.out.println("Enter Password: ");
				staffPassword=sc.next();
				System.out.println("Enter Staff Address: ");
				staffAddress=sc.next();
				System.out.println("Enter Staff Rule: ");
				staffRule=sc.next();
				System.out.println("Enter Staff Salary: ");
				staffSalary=sc.nextLong();
				
				b.setStaffId(staffId);
				b.setStaffName(staffName);
				b.setDepartmentName(departmentName);
				b.setStaffContact(staffContact);
				b.setStaffEmailId(staffEmailId);
				b.setStaffPassword(staffPassword);
				b.setStaffAddress(staffAddress);
				b.setStaffRule(staffRule);
				b.setStaffSalary(staffSalary);
				
	            
	            flag=bs.updateBankStaff(b);
	           
	          // System.out.println(flag);
	            if(flag==true) {
	            	System.out.println("Staff Update Successfully....");
	            }
	            else {
	            	System.out.println("Staff Update Failed...");
	            }
				break;
			case 3 :
				System.out.println("--------------------ENTER ID TO DELETE STAFF---------------------------");
				System.out.println("Enter Staff Id: ");
				staffId=sc.nextInt();
				
				
				flag=bs.deleteBankStaff(staffId);
				
				if(flag==true) {
					System.out.println("Account Delete Successfully");
				}else {
					System.out.println("Account Delete Failed..");
				}
				break;
			case 4 :
				System.out.println("--------------------ENTER ID TO DISPLAY Bank Staff---------------------------");
				System.out.println("Enter Staff ID: ");
				staffId=sc.nextInt();
				
				b=bs.displayBankStaffByStaffId(staffId);
			System.out.println("***********Staff Details**************");
			System.out.println(b.getStaffName()+" "+b.getDepartmentName()+" "+b.getStaffContact()+" "+b.getStaffEmailId()+" "+b.getStaffPassword()+" "+b.getStaffAddress()+" "+b.getStaffRule()+" "+b.getStaffSalary());
				
				break;
			case 5 :
				System.out.println("--------------------EXISTING Account DETAILS---------------------------");
				
				ArrayList<BankStaff> af=new ArrayList<BankStaff>();
				af=bs.displayAllBankStaff();
				
				for(BankStaff i:af) {
					System.out.println("BankStaff ID: "+i.getStaffId());
					System.out.println("BankStaff Name: "+i.getStaffName());
					System.out.println("Department Name: "+i.getDepartmentName());
					System.out.println("Staff Contact: "+i.getStaffContact());
					System.out.println("Staff EmailId: "+i.getStaffEmailId());
					System.out.println("Staff Password: "+i.getStaffPassword());
					System.out.println("Staff Address : "+i.getStaffAddress());
					System.out.println("Staff rule: "+i.getStaffRule());
					System.out.println("Staff Salary: "+i.getStaffSalary());
					
					
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
