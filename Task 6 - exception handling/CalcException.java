package com.orthofx;

import java.util.Scanner;

public class CalcException {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		char choice;
		
		do {
			System.out.println("Enter 2 numbers: ");
			int n1=s.nextInt();
			int n2=s.nextInt();
			System.out.println("Enter an arithmetic operator: ");
			char op=s.next().charAt(0);		
		
			switch (op) {
			case '+':
				System.out.println(n1+ " + " +n2+ " = " +(n1+n2));			
				break;
			case '-':
				System.out.println(n1+ " - " +n2+ " = " +(n1-n2));			
				break;
			case '*':
				System.out.println(n1+ " * " +n2+ " = " +(n1*n2));			
				break;
			case '/':
				try {
					System.out.println(n1+ " / " +n2+ " = " +(n1/n2));
				}catch(ArithmeticException e) {
	            System.out.println("Cannot be divided by 0");
	         }								
				break;
			case '%':
				System.out.println(n1+ " % " +n2+ " = " +(n1%n2));				
				break;
			
			default:
				System.out.println("Operator should be one among the following '+','-','*','/','%'");
				break;
			}
			System.out.println("\nPress y to continue...");
			choice=s.next().charAt(0);
			}		
		while(choice == 'y' || choice =='Y');
		
		
		
		
	
					
	}		
	
	
	

}
