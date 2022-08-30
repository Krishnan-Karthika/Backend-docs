package com.orthofx.entities;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class App {
	private static Map<Integer,Company> companyTable=new HashMap<>();
	private static Map<Integer,Employee> employeeTable=new HashMap<>();
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String companyName,employeeName;
		int employeeID,companyID;
		int op,rep;
		
		do {
			
		
		System.out.println("Select the entity \n 1.Company \n 2.Employee");
		int ch=sc.nextInt();
				
		switch(ch) {
		case 1:
			do {
				System.out.println("Select the operation to perform in Company records \n 1.Create \n 2.Retrieve \n 3.Update \n 4.Delete");
				op=sc.nextInt();
				
				switch(op) {
				case 1:
					System.out.println("Enter name of company");
					companyName=sc.next();
					createCompany(companyName);
					break;
				case 2:
					System.out.println("Enter company ID");
					companyID=sc.nextInt();
					if(companyTable.containsKey(companyID)) 
						getCompany(companyID);
					else System.out.println("Record not found");
					
					
					break;
				case 3:
					System.out.println("Enter company ID");
					companyID=sc.nextInt();
					if(companyTable.containsKey(companyID)) {
						System.out.println("Enter updated name of company");
						companyName=sc.next();
						updateCompany(companyID,companyName);
						
					}else System.out.println("Record not found");					
					break;
				case 4:
					System.out.println("Enter company ID");
					companyID=sc.nextInt();
					if(companyTable.containsKey(companyID))
						deleteCompany(companyID);
					else System.out.println("Record not found");
					break;
				default:
					System.out.println("invalid entry");
					break;
				}
				System.out.println("Press 1 to continue operations in company records");
				rep=sc.nextInt();
			}
			while(rep==1);
			break;
			
		case 2:
			do {
				System.out.println("Select the operation to perform in Employee records \n 1.Create \n 2.Retrieve \n 3.Update \n 4.Delete");
				op=sc.nextInt();
				
				switch(op) {
				case 1:
					System.out.println("Enter name of employee");
					employeeName=sc.next();
					System.out.println("Enter company ID of employee");
					companyID=sc.nextInt();
					Company company=companyTable.get(companyID);
					createEmployee(employeeName,company);
					break;
				case 2:
					System.out.println("Enter employee ID");
					employeeID=sc.nextInt();
					if(employeeTable.containsKey(employeeID))
						getEmployee(employeeID);
					else System.out.println("Record not found");
					break;
				case 3:
					System.out.println("Enter employee ID");
					employeeID=sc.nextInt();
					if(employeeTable.containsKey(employeeID)) {
						System.out.println("Enter updated name of employee");
						employeeName=sc.next();
						System.out.println("Enter company ID of employee");
						companyID=sc.nextInt();
						Company empCompanyID=companyTable.get(companyID);
						updateEmployee(employeeID,employeeName,empCompanyID);
					}else System.out.println("Record not found");					
					break;
				case 4:
					System.out.println("Enter employee ID");
					employeeID=sc.nextInt();
					if(employeeTable.containsKey(employeeID))
						deleteEmployee(employeeID);
					else System.out.println("Record not found");
					break;
				default:
					System.out.println("invalid entry");
					break;
			}
				System.out.println("Press 1 to continue operations in Employee records");
				rep=sc.nextInt();
			}
			while(rep==1);
			break;
			
	}
		System.out.println("Press 1 to continue operations in Entities");
		rep=sc.nextInt();
	}
	while(rep==1);
	}
	
	public static Company createCompany(String name) {
		Company company=new Company(companyTable.size()+1,name);
		companyTable.put(company.getID(),company);
		return company;
	}
	
	public static Employee createEmployee(String name,Company company) {
		Employee employee=new Employee(employeeTable.size()+1,name,company);
		employeeTable.put(employee.getID(), employee);
		return employee;		
	}
	
	public static void getCompany(int id) {
		Company company=companyTable.get(id);
		System.out.println(company.getName());
	}
	
	public static void getEmployee(int id) {
		Employee employee=employeeTable.get(id);
		System.out.println(employee.getName()+"  "+employee.getCompanyName());
	}
	
	public static Company updateCompany(int id,String name) {
		Company company=new Company(id,name);
		companyTable.put(id, company);
		return company;
	}
	
	public static Employee updateEmployee(int id,String name, Company company) {
		Employee employee=new Employee(id,name,company);		
		employeeTable.put(id, employee);
		return employee;
	}
	
	public static void deleteCompany(int id) {
		companyTable.remove(id);
	}
	
	public static void deleteEmployee(int id) {
		employeeTable.remove(id);
	}
	
	
}
